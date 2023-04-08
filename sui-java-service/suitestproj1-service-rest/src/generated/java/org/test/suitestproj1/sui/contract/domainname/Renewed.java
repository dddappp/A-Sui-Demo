// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.sui.contract.domainname;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.test.suitestproj1.sui.contract.*;

import java.math.*;
import java.util.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Renewed {
    private String id;

    private DomainNameIdForEvent domainNameId;

    private BigInteger version;

    private BigInteger renewPeriod;

    private String account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DomainNameIdForEvent getDomainNameId() {
        return domainNameId;
    }

    public void setDomainNameId(DomainNameIdForEvent domainNameId) {
        this.domainNameId = domainNameId;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public BigInteger getRenewPeriod() {
        return renewPeriod;
    }

    public void setRenewPeriod(BigInteger renewPeriod) {
        this.renewPeriod = renewPeriod;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Renewed{" +
                "id='" + id + '\'' +
                ", domainNameId=" + domainNameId +
                ", version=" + version +
                ", renewPeriod=" + renewPeriod +
                ", account=" + '\'' + account + '\'' +
                '}';
    }

}
