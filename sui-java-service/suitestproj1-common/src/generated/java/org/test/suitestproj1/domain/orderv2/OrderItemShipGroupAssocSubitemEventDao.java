// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.domain.orderv2;

import org.test.suitestproj1.domain.*;
import java.util.Date;

public interface OrderItemShipGroupAssocSubitemEventDao {
    void save(OrderItemShipGroupAssocSubitemEvent e);

    Iterable<OrderItemShipGroupAssocSubitemEvent> findByOrderItemShipGroupAssociationEventId(OrderItemShipGroupAssociationEventId orderItemShipGroupAssociationEventId);

}
