// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.domain.order;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.test.suitestproj1.domain.*;
import org.test.suitestproj1.specialization.Event;

public interface OrderEvent extends Event, SuiEventEnvelope, SuiMoveEvent, HasStatus {

    interface SqlOrderEvent extends OrderEvent {
        OrderEventId getOrderEventId();

        boolean getEventReadOnly();

        void setEventReadOnly(boolean readOnly);
    }

    String getId();

    //void setId(String id);

    BigInteger getVersion();
    
    //void setVersion(BigInteger version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getCommandId();

    void setCommandId(String commandId);


}
