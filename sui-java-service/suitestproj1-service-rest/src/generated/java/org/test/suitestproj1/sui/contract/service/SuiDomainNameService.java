// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.sui.contract.service;

import com.github.wubuku.sui.utils.SuiJsonRpcClient;
import org.test.suitestproj1.domain.*;
import org.test.suitestproj1.domain.domainname.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class SuiDomainNameService {

    @Autowired
    private DomainNameStateRepository domainNameStateRepository;

    private SuiDomainNameStateRetriever suiDomainNameStateRetriever;

    @Autowired
    public SuiDomainNameService(SuiJsonRpcClient suiJsonRpcClient) {
        this.suiDomainNameStateRetriever = new SuiDomainNameStateRetriever(suiJsonRpcClient,
                domainNameId -> {
                    DomainNameState.MutableDomainNameState s = new AbstractDomainNameState.SimpleDomainNameState();
                    s.setDomainNameId(domainNameId);
                    return s;
                }
        );
    }

    @Transactional
    public void updateDomainNameState(String objectId) {
        DomainNameState domainNameState = suiDomainNameStateRetriever.retrieveDomainNameState(objectId);
        domainNameStateRepository.merge(domainNameState);
    }


}

