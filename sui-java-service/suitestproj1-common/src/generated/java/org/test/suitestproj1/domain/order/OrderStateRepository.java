// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.domain.order;

import java.util.*;
import org.dddml.support.criterion.Criterion;
import java.math.BigInteger;
import java.util.Date;
import org.test.suitestproj1.domain.*;

public interface OrderStateRepository {
    OrderState get(String id, boolean nullAllowed);

    void save(OrderState state);

    void merge(OrderState detached);
}

