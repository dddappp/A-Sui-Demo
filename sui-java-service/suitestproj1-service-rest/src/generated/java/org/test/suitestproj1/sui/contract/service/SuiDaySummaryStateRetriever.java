// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.sui.contract.service;

import com.github.wubuku.sui.bean.*;
import com.github.wubuku.sui.utils.*;
import org.test.suitestproj1.domain.daysummary.*;
import org.test.suitestproj1.domain.*;
import org.test.suitestproj1.sui.contract.DomainBeanUtils;
import org.test.suitestproj1.sui.contract.DaySummary;

import java.util.*;
import java.math.*;
import java.util.function.*;

public class SuiDaySummaryStateRetriever {

    private SuiJsonRpcClient suiJsonRpcClient;

    private Function<Day, DaySummaryState.MutableDaySummaryState> daySummaryStateFactory;

    public SuiDaySummaryStateRetriever(SuiJsonRpcClient suiJsonRpcClient,
                                  Function<Day, DaySummaryState.MutableDaySummaryState> daySummaryStateFactory
    ) {
        this.suiJsonRpcClient = suiJsonRpcClient;
        this.daySummaryStateFactory = daySummaryStateFactory;
    }

    public DaySummaryState retrieveDaySummaryState(String objectId) {
        SuiMoveObjectResponse<DaySummary> getObjectDataResponse = suiJsonRpcClient.getMoveObject(
                objectId, new SuiObjectDataOptions(true, true, true, true, true, true, true), DaySummary.class
        );

        DaySummary daySummary = getObjectDataResponse.getData().getContent().getFields();
        return toDaySummaryState(daySummary);
    }

    private DaySummaryState toDaySummaryState(DaySummary daySummary) {
        DaySummaryState.MutableDaySummaryState daySummaryState = daySummaryStateFactory.apply(DomainBeanUtils.toDay(daySummary.getDay()));
        daySummaryState.setId_(daySummary.getId().getId());
        daySummaryState.setVersion(daySummary.getVersion());
        daySummaryState.setDescription(daySummary.getDescription());
        daySummaryState.setMetadata(daySummary.getMetadata());
        daySummaryState.setArrayData(new HashSet<>(Arrays.asList(daySummary.getArrayData())));
        daySummaryState.setOptionalData(daySummary.getOptionalData());
        return daySummaryState;
    }

    
}

