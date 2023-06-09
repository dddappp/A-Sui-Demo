// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.domain.orderv2;

import java.util.*;
import java.math.BigInteger;
import org.test.suitestproj1.domain.*;
import java.util.Date;
import org.test.suitestproj1.specialization.Event;

public interface OrderV2Event extends Event, SuiEventEnvelope, SuiMoveEvent, HasStatus {

    interface SqlOrderV2Event extends OrderV2Event {
        OrderV2EventId getOrderV2EventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getOrderId();

    //void setOrderId(String orderId);

    BigInteger getVersion();
    
    //void setVersion(BigInteger version);

    String getId_();
    
    //void setId_(String id);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);


}

