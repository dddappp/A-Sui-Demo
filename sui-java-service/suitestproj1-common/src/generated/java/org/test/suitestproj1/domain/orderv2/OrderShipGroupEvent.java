// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.domain.orderv2;

import java.util.*;
import java.util.Date;
import org.test.suitestproj1.domain.*;
import org.test.suitestproj1.specialization.Event;

public interface OrderShipGroupEvent extends Event {

    interface SqlOrderShipGroupEvent extends OrderShipGroupEvent {
        OrderShipGroupEventId getOrderShipGroupEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    Integer getShipGroupSeqId();

    //void setShipGroupSeqId(Integer shipGroupSeqId);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);


}

