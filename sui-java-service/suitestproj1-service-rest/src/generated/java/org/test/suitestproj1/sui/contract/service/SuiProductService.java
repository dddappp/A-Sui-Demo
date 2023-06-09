// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.sui.contract.service;

import com.github.wubuku.sui.utils.SuiJsonRpcClient;
import org.test.suitestproj1.domain.*;
import org.test.suitestproj1.domain.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
public class SuiProductService {

    @Autowired
    private ProductStateRepository productStateRepository;

    private SuiProductStateRetriever suiProductStateRetriever;

    @Autowired
    public SuiProductService(SuiJsonRpcClient suiJsonRpcClient) {
        this.suiProductStateRetriever = new SuiProductStateRetriever(suiJsonRpcClient,
                productId -> {
                    ProductState.MutableProductState s = new AbstractProductState.SimpleProductState();
                    s.setProductId(productId);
                    return s;
                }
        );
    }

    @Transactional
    public void updateProductState(String objectId) {
        ProductState productState = suiProductStateRetriever.retrieveProductState(objectId);
        productStateRepository.merge(productState);
    }


}

