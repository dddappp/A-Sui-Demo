# Developing Sui Decentralized Applications using the dddappp Low-Code Tool

English | [中文](README_CN.md)

## Prerequisites

Currently, the dddappp low-code tool is published as a Docker image for developers to experience.

The off-chain services generated by the tool are written in Java and use the MySQL database by default.

So before getting started, you need to:

* Install [Sui](https://docs.sui.io/build/install).

* Install [Docker](https://docs.docker.com/engine/install/).

* Install MySQL database server.

* Install JDK and Maven. The off-chain services generated by the tool currently use Java.

If you have already installed Docker, you can use Docker to run a MySQL database service. For example:

```shell
sudo docker run -p 3306:3306 --name mysql \
-v ~/docker/mysql/conf:/etc/mysql \
-v ~/docker/mysql/logs:/var/log/mysql \
-v ~/docker/mysql/data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=123456 \
-d mysql:5.7
```

## Example: Reproduce the Development Process of the Demo Application

We have placed a Demo application developed using the dddappp low-code tool on GitHub. The application code is divided into two parts:

* Sui Move on-chain contracts: https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/sui_contracts
* Java off-chain service: https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/sui-java-service

You can follow the instructions below to reproduce the development process of this Demo.

It should be noted that we assume that you want to deploy the Move contracts to the Sui devnet, so we skip the instructions on how to modify certain configuration files required for deployment to other networks.

> **Tip**
>
> The data models used in this demo are quite complex and require you to "write" some business logic (although you may just need to copy and paste them). 
> 
> If your business requirements are only to perform CRUD (Create, Read, Update, Delete) on some data models, then, this example may be more suitable for your reference:
> https://github.com/dddappp/sui-blog-example


### Write DDDML Model Files

Our low-code tool relies on the domain model described by DDDML (Domain-Driven Design Modeling Language) to generate various parts of the application code.

> **Tip**
>
> About DDDML, here is an introductory article: ["Introducing DDDML: The Key to Low-Code Development for Decentralized Applications"](https://github.com/wubuku/Dapp-LCDP-Demo/blob/main/IntroducingDDDML.md). This article contains detailed explanations of some DDDML model files used in this Demo.

You can create a directory, for example, called `test`, to place all the application code, and then create a subdirectory `dddml` within this directory. We generally put the model files written according to the DDDML specification in this directory.

You can download/copy the sample model files here to the `dddml` directory: https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/domain-model/sui

In these models, some of the fabricated examples may have become a bit "absurdly" complicated, but our tool is not "stumped".

### Run dddappp Project Creation Tool

Use Docker to run the project creation tool:

```shell
docker run \
-v /PATH/TO/test:/myapp \
wubuku/dddappp:0.0.1 \
--dddmlDirectoryPath /myapp/dddml \
--boundedContextName Test.SuiTestProj1 \
--boundedContextJavaPackageName org.test.suitestproj1 \
--boundedContextSuiPackageName sui_test_proj1 \
--javaProjectsDirectoryPath /myapp/sui-java-service \
--javaProjectNamePrefix suitestproj1 \
--pomGroupId test.suitestproj1 \
--suiMoveProjectDirectoryPath /myapp/sui-contracts
```

The command parameters above are straightforward:

* Note that `/PATH/TO/test` should be replaced with the path of the local directory where you actually place the application code. This line indicates mounting the local directory into the `/myapp` directory inside the container.
* `dddmlDirectoryPath` is the directory where the DDDML model files are located. It should be a directory path that can be read in the container.
* Understand the value of the `boundedContextName` parameter as the name of the application you want to develop. When the name has multiple parts, separate them with dots and use the PascalCase naming convention for each part. Bounded-context is a term in Domain-driven design (DDD) that refers to a specific problem domain scope that contains specific business boundaries, constraints, and language. If you cannot understand this concept for the time being, it is not a big deal.
* `boundedContextJavaPackageName` is the Java package name of the off-chain service. According to Java naming conventions, it should be all lowercase and the parts should be separated by dots.
* `boundedContextSuiPackageName` is the package name of the on-chain Sui contracts. According to the Sui development convention, it should be named in snake_case style with all lowercase letters.
* `javaProjectsDirectoryPath` is the directory path where the off-chain service code is placed. The off-chain service consists of multiple modules (projects). It should be a readable and writable directory path in the container.
* `javaProjectNamePrefix` is the name prefix of each module of the off-chain service. It is recommended to use an all-lowercase name.
* `pomGroupId` is the GroupId of the off-chain service. We use Maven as the project management tool for off-chain service. It should be all lowercase and the parts should be separated by dots.
* `suiMoveProjectDirectoryPath` is the directory path where the on-chain Sui contract code is placed. It should be a readable and writable directory path in the container.

After the above command is successfully executed, two directories `sui-java-service` and `sui-contracts` should be added to the local directory `/PATH/TO/test`.

Now you can try to compile the off-chain service. Go to the directory `sui-java-service` and run:

```shell
mvn compile
```

If there is no unexpected failure, the compilation should be successful.

At this point, the on-chain contracts cannot be compiled because the "business logic" has not been implemented yet. Now we will implement it.


### Implementing Business Logic

The tool has generated some files with the suffix `_logic.move` in the directory `sui-contracts/sources`. These files contain skeleton code of functions that implement business logic, namely the signature part of the functions. Now you just need to fill in the implementation part of the functions.

You can consider copying the implementation code of the business logic that has been written here: https://github.com/wubuku/Dapp-LCDP-Demo/tree/main/sui-contracts/sources

You can also clone the code repository of this Demo application and then execute a shell script like the following to complete the copy work (note that replace `_PATH_TO_/Dapp-LCDP-Demo` and `_PATH_TO_/test` with the actual paths on your local machine):

```shell
#!/bin/bash

source_dir="_PATH_TO_/Dapp-LCDP-Demo/sui-contracts/sources"
target_dir="_PATH_TO_/test/sui-contracts/sources"

old_keyword="sui_contracts"
new_keyword="sui_test_proj1"

for file in "${source_dir}"/*_logic.move; do
  if [[ -f "$file" ]] && grep -q "$old_keyword" "$file"; then
    cp "$file" "${target_dir}/$(basename "$file")"
    sed -i "" "s/$old_keyword/$new_keyword/g" "${target_dir}/$(basename "$file")"
  fi
done
```

Then go to the directory `sui-contracts` and compile it, which should be successful:

```shell
sui move build
```

So far, the coding phase of application development is completed! Wasn't it pretty simple?

---

Now, let's move on to deploying and testing the application.


### Publish the Sui contracts

After completing the implementation of the business logic, execute the following command in the directory `sui-contracts` to publish the contracts to the chain:

```shell
sui client publish --gas-budget 30000
```
> *Tip*
> 
> Sometimes the gas price on the testnet is very high, so you may need to adjust the value of the `gas-budget` parameter in the command as needed.

If the command is executed successfully, the transaction digest of this publication will be output. For example:

```shell
----- Transaction Digest ----
BZXe8c5nBjoyacUJTkcfoLgFuU9xWRksAMSfaEU3XrSM
----- Transaction Data ----
#...
```
Take note of this transaction digest.


### Configuring Off-Chain Service

Open the `application-test.yml` file located in the directory `sui-java-service/suitestproj1-service-rest/src/main/resources` and set the published transaction digest. After setting, it should look like this:

```yaml
sui:
  contract:
    jsonrpc:
      url: "https://fullnode.devnet.sui.io/"
      #url: "http://localhost:9000"
    package-publish-transaction: "BZXe8c5nBjoyacUJTkcfoLgFuU9xWRksAMSfaEU3XrSM"
```

This is the only place where off-chain service need to be configured, and it's that simple.


### Creating a Database for Off-Chain Service

Use a MySQL client to connect to the local MySQL server and execute the following script to create an empty database (assuming the name is `test2`):

```sql
CREATE SCHEMA `test2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
```

Go to the `sui-java-service` directory and package the Java project:

```shell
mvn package
```

Then, run a command-line tool to initialize the database:

```shell
java -jar ./suitestproj1-service-cli/target/suitestproj1-service-cli-0.0.1-SNAPSHOT.jar ddl -d "./scripts" -c "jdbc:mysql://127.0.0.1:3306/test2?enabledTLSProtocols=TLSv1.2&characterEncoding=utf8&serverTimezone=GMT%2b0&useLegacyDatetimeCode=false" -u root -p 123456
```

### Starting Off-Chain Service

In the `sui-java-service` directory, run the following command to start the off-chain service:

```shell
mvn -pl suitestproj1-service-rest -am spring-boot:run
```

### Tip: Using this Cheatsheet

After the off-chain services are started, you can access this URL to get a cheatsheet on how to use the Sui Client CLI to call on-chain contracts: http://localhost:1023/api/sui.contract/SuiClientCLICheatsheet.md

In the cheatsheet, the Package Id of the contracts you just published and the Object Ids (created according to the Id Generators declared in models) you need when creating certain entities are already filled in for you. The parameters you need to fill in are placeholders containing their type and meaning (name). You can copy these commands, modify them as needed, and execute them directly in a terminal.

### Submitting some test transactions

Next, you can try submitting some transactions and calling the Move function on-chain.

For example, creating a product:

```shell
sui client call --package 0x88e91efb24e2e2fc9255af351d5035797071500df38b915f15b74271f389a595 --module product_aggregate --function create \
--args \"product_name_1\" \"1000\" \"0x95cf09389ed279d22e0df9baee507457e0359518c396569aa8f1247b918fb73d\" \
--gas-budget 100000
```

Output similar to:

```shell
----- Transaction Effects ----
Status : Success
Created Objects:
  - ID: 0x96b16b23bcf70562889f2e6c74b3561d00829afade0b498dfa69bc085e2bc318 , Owner: Immutable
```

Record the Object Id of the product output by the above command, as we will use it to create an order.

Of course, you can also use the RESTful API of the off-chain service to obtain information on the products that have been created: http://localhost:1023/api/Products

Execute the following command to create an order:

```shell
sui client call --package 0x88e91efb24e2e2fc9255af351d5035797071500df38b915f15b74271f389a595 --module order_aggregate --function create \
--args \"0x96b16b23bcf70562889f2e6c74b3561d00829afade0b498dfa69bc085e2bc318\" \"1\" \
--gas-budget 100000
```

You can access the RESTful API to get information about orders that have been created: http://localhost:1023/api/Orders

You can use parameters to filter orders, such as: http://localhost:1023/api/Orders?totalAmount=1000

---

We know that the input parameters for a transaction calling the Sui Move contract can only contain primitive types or object references. In our DDDML example model, the domain ID of the DaySummary object is a "nested nested value object", and this ID is assigned by the user through the "Create" method. Don't worry, the code generated by the tool will take care of this problem for you.

Execute the following command to create a DaySummary object:

```shell
sui client call --package 0x88e91efb24e2e2fc9255af351d5035797071500df38b915f15b74271f389a595 --module day_summary_aggregate --function create \
--args 2023 \"ChineseLunar\" 4 false 10 \"Shanghai\" \"string_description\" \"vector_u8_meta_data\" '["string_array_data_item"]' '["vector_u8_optional_data"]' \"0x1676110fa451e75daf1d6a0204053662a8936e4267d475ac9e38101b9d1de340\" \
--gas-budget 100000
```

Then, through this interface, you can get a list of created DaySummary objects: http://localhost:1023/api/DaySummaries


### Source Code

You may have noticed that the source code reproduced based on the above process has been placed in this repository: https://github.com/dddappp/A-Sui-Demo

## Ignore Generating Files

In the code files generated by the project creation tool, a large part is template code generated based on the model. When the model is modified and the project creation tool is run again, these code files will be regenerated and overwritten by default. Most of these files have a comment with the word "autogenerated" at the beginning.

If you want to modify these files and not have them overwritten when the code is regenerated, you can place a `.dddmlignore` file in a specific directory:

* The directory specified by the `javaProjectsDirectoryPath` parameter.
* The directory specified by the `suiMoveProjectDirectoryPath` parameter.

The `.dddmlignore` file is similar to a `.gitignore` file, with each line representing an ignore rule. For example, the following rule means that all files starting with "Order" or "order" in all directory levels need to be ignored when regenerated:

```text
**/[Oo]rder*
```

## Stay Tuned

### Adding JSON Schema

You may find it a bit troublesome to write a DSL model manually, but don't worry, we are writing a JSON schema for DDDML. Here is a schema file that still needs to be improved: https://raw.githubusercontent.com/wubuku/dddml-spec/master/schemas/dddml-schema.json

DDDML is a YAML-based DSL, and YAML is a superset of JSON, so JSON schema can be effective.

If your IDE supports it, you can configure it, and then have support for features like automatic completion when writing DDDML models.

For example, in VS Code's `.vscode/settings.json` file, you can set it up like this:

```json
{
    "yaml.schemas": {
        "https://raw.githubusercontent.com/wubuku/dddml-spec/master/schemas/dddml-schema.json": [
            "dddml/*.yaml", //file match pattern
            "dddml/*.yml"
        ]
    }
}
```

### GUI Modeling Tool or AI-assisted Modeling?

Our previous idea, our next step, was to initiate the development of a graphical modeling tool.

However, we now have a further idea, which is to train AI and let AI help us write DDDML code. We think that this might be a better direction.

### Adding More Support for DDDML Specification

In developing Dapps based on Sui, our command-line tools currently support the basic parts of the DDDML specification.

In terms of using DDDML to drive traditional application development, we have a lot of practical experience to migrate to the new Dapp low-code development tools.

For example:

* Adding support for "Domain Fundamental Types" to Dapp low-code tools.
    * Currently, our Dapp low-code tools have implemented support for Move's primitive types, as well as support for "data value objects" composed of primitive types without business logic.
    * DDDML advocates and encourages the use of domain terms for analysis and modeling. We hope to achieve that: after the team unanimously recognizes a domain concept as a value object, it can be used directly as the type of an attribute in DDDML files. As for the specific implementation of this type, it can be abstracted into an independent library.

* We can declare the inheritance relationship of entities in the model, and the tool can generate appropriate code for us, even if the Move language itself does not support object inheritance.

* We can add support for state machine patterns. Some entities in the domain may have important "qualitative" attributes, and UML specifically provides state machine diagrams to describe them. Naturally, DDDML will not miss the support for state machine patterns.

* We can add support for "trees" - hierarchical structures. We often encounter scenarios that require the construction of hierarchical structures. For example, the internal organization of a company, with its various departments and branches, may form one or even multiple hierarchical structures.

* ...

### Further Exploration of the Combination of "Resource-oriented" and DDDML Specification

We believe that the DDDML specification can further develop to fully utilize the advantages of the resource-oriented programming paradigm of Move.

## Some Tips

### Clean Up Exited Docker Containers

Run the command:

```shell
docker rm $(docker ps -aq --filter "ancestor=wubuku/dddappp:0.0.1")
```

