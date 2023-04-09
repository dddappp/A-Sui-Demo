// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.domain.orderv2;

import java.util.List;
import java.math.BigInteger;
import org.test.suitestproj1.domain.*;
import java.util.Date;
import org.test.suitestproj1.specialization.Event;
import org.test.suitestproj1.domain.Command;

public interface OrderV2Aggregate {
    OrderV2State getState();

    List<Event> getChanges();

    void create(String product, BigInteger quantity, Long offChainVersion, String commandId, String requesterId, OrderV2Commands.Create c);

    void removeItem(String productId, Long offChainVersion, String commandId, String requesterId, OrderV2Commands.RemoveItem c);

    void updateItemQuantity(String productId, BigInteger quantity, Long offChainVersion, String commandId, String requesterId, OrderV2Commands.UpdateItemQuantity c);

    void updateEstimatedShipDate(Day estimatedShipDate, Long offChainVersion, String commandId, String requesterId, OrderV2Commands.UpdateEstimatedShipDate c);

    void addOrderShipGroup(Integer shipGroupSeqId, String shipmentMethod, String productId, BigInteger quantity, Long offChainVersion, String commandId, String requesterId, OrderV2Commands.AddOrderShipGroup c);

    void cancelOrderShipGroupQuantity(Integer shipGroupSeqId, String productId, BigInteger cancelQuantity, Long offChainVersion, String commandId, String requesterId, OrderV2Commands.CancelOrderShipGroupQuantity c);

    void removeOrderShipGroupItem(Integer shipGroupSeqId, String productId, Long offChainVersion, String commandId, String requesterId, OrderV2Commands.RemoveOrderShipGroupItem c);

    void removeOrderShipGroup(Integer shipGroupSeqId, Long offChainVersion, String commandId, String requesterId, OrderV2Commands.RemoveOrderShipGroup c);

    void throwOnInvalidStateTransition(Command c);
}
