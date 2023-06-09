// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.sui.contract.repository;

import org.test.suitestproj1.domain.order.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface OrderEventRepository extends JpaRepository<AbstractOrderEvent, OrderEventId> {

    List<AbstractOrderEvent> findByStatusIsNull();

    AbstractOrderEvent.OrderCreated findFirstOrderCreatedByOrderBySuiTimestampDesc();

    AbstractOrderEvent.OrderItemRemoved findFirstOrderItemRemovedByOrderBySuiTimestampDesc();

    AbstractOrderEvent.OrderItemQuantityUpdated findFirstOrderItemQuantityUpdatedByOrderBySuiTimestampDesc();

}
