// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.domain.orderv2;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.test.suitestproj1.domain.*;
import org.test.suitestproj1.domain.Command;
import org.test.suitestproj1.specialization.DomainError;

public interface OrderV2ItemCommand extends Command {

    String getProductId();

    void setProductId(String productId);

}

