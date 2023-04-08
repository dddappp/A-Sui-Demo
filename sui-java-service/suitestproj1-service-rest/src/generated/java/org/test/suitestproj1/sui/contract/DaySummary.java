// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.sui.contract;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.wubuku.sui.bean.*;

import java.math.*;
import java.util.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DaySummary {

    private UID id;

    private Day day;

    private Long offChainVersion;

    private String description;

    private int[] metadata;

    private String[] arrayData;

    private int[] optionalData;

    private BigInteger version;

    public UID getId() {
        return id;
    }

    public void setId(UID id) {
        this.id = id;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Long getOffChainVersion() {
        return offChainVersion;
    }

    public void setOffChainVersion(Long offChainVersion) {
        this.offChainVersion = offChainVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int[] getMetadata() {
        return metadata;
    }

    public void setMetadata(int[] metadata) {
        this.metadata = metadata;
    }

    public String[] getArrayData() {
        return arrayData;
    }

    public void setArrayData(String[] arrayData) {
        this.arrayData = arrayData;
    }

    public int[] getOptionalData() {
        return optionalData;
    }

    public void setOptionalData(int[] optionalData) {
        this.optionalData = optionalData;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "DaySummary{" +
                "id=" + id +
                ", day=" + day +
                ", offChainVersion=" + offChainVersion +
                ", description=" + '\'' + description + '\'' +
                ", metadata=" + Arrays.toString(metadata) +
                ", arrayData=" + Arrays.toString(arrayData) +
                ", optionalData=" + Arrays.toString(optionalData) +
                ", version=" + version +
                '}';
    }
}
