// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.sui.contract.service;

import com.github.wubuku.sui.bean.EventId;
import com.github.wubuku.sui.bean.Page;
import com.github.wubuku.sui.bean.PaginatedMoveEvents;
import com.github.wubuku.sui.bean.SuiMoveEventEnvelope;
import com.github.wubuku.sui.utils.SuiJsonRpcClient;
import org.test.suitestproj1.domain.order.AbstractOrderEvent;
import org.test.suitestproj1.sui.contract.ContractConstants;
import org.test.suitestproj1.sui.contract.DomainBeanUtils;
import org.test.suitestproj1.sui.contract.SuiPackage;
import org.test.suitestproj1.sui.contract.order.OrderCreated;
import org.test.suitestproj1.sui.contract.order.OrderItemRemoved;
import org.test.suitestproj1.sui.contract.order.OrderItemQuantityUpdated;
import org.test.suitestproj1.sui.contract.repository.OrderEventRepository;
import org.test.suitestproj1.sui.contract.repository.SuiPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderEventService {

    @Autowired
    private SuiPackageRepository suiPackageRepository;

    @Autowired
    private SuiJsonRpcClient suiJsonRpcClient;

    @Autowired
    private OrderEventRepository orderEventRepository;

    @Transactional
    public void updateStatusToProcessed(AbstractOrderEvent event) {
        event.setStatus("D");
        orderEventRepository.save(event);
    }

    @Transactional
    public void pullOrderCreatedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getOrderCreatedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<OrderCreated> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.ORDER_MODULE_ORDER_CREATED,
                    cursor, limit, false, OrderCreated.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<OrderCreated> eventEnvelope : eventPage.getData()) {
                    saveOrderCreated(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getOrderCreatedEventNextCursor() {
        AbstractOrderEvent lastEvent = orderEventRepository.findFirstOrderCreatedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveOrderCreated(SuiMoveEventEnvelope<OrderCreated> eventEnvelope) {
        AbstractOrderEvent.OrderCreated orderCreated = DomainBeanUtils.toOrderCreated(eventEnvelope);
        if (orderEventRepository.findById(orderCreated.getOrderEventId()).isPresent()) {
            return;
        }
        orderEventRepository.save(orderCreated);
    }

    @Transactional
    public void pullOrderItemRemovedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getOrderItemRemovedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<OrderItemRemoved> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.ORDER_MODULE_ORDER_ITEM_REMOVED,
                    cursor, limit, false, OrderItemRemoved.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<OrderItemRemoved> eventEnvelope : eventPage.getData()) {
                    saveOrderItemRemoved(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getOrderItemRemovedEventNextCursor() {
        AbstractOrderEvent lastEvent = orderEventRepository.findFirstOrderItemRemovedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveOrderItemRemoved(SuiMoveEventEnvelope<OrderItemRemoved> eventEnvelope) {
        AbstractOrderEvent.OrderItemRemoved orderItemRemoved = DomainBeanUtils.toOrderItemRemoved(eventEnvelope);
        if (orderEventRepository.findById(orderItemRemoved.getOrderEventId()).isPresent()) {
            return;
        }
        orderEventRepository.save(orderItemRemoved);
    }

    @Transactional
    public void pullOrderItemQuantityUpdatedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getOrderItemQuantityUpdatedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<OrderItemQuantityUpdated> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.ORDER_MODULE_ORDER_ITEM_QUANTITY_UPDATED,
                    cursor, limit, false, OrderItemQuantityUpdated.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<OrderItemQuantityUpdated> eventEnvelope : eventPage.getData()) {
                    saveOrderItemQuantityUpdated(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getOrderItemQuantityUpdatedEventNextCursor() {
        AbstractOrderEvent lastEvent = orderEventRepository.findFirstOrderItemQuantityUpdatedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveOrderItemQuantityUpdated(SuiMoveEventEnvelope<OrderItemQuantityUpdated> eventEnvelope) {
        AbstractOrderEvent.OrderItemQuantityUpdated orderItemQuantityUpdated = DomainBeanUtils.toOrderItemQuantityUpdated(eventEnvelope);
        if (orderEventRepository.findById(orderItemQuantityUpdated.getOrderEventId()).isPresent()) {
            return;
        }
        orderEventRepository.save(orderItemQuantityUpdated);
    }


    private String getDefaultSuiPackageId() {
        return suiPackageRepository.findById(ContractConstants.DEFAULT_SUI_PACKAGE_NAME)
                .map(SuiPackage::getObjectId).orElse(null);
    }
}
