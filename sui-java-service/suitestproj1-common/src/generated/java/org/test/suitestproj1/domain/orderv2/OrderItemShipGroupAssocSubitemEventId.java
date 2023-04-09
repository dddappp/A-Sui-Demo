// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.domain.orderv2;

import java.io.Serializable;
import org.test.suitestproj1.domain.Day;
import java.math.BigInteger;
import org.test.suitestproj1.domain.*;

public class OrderItemShipGroupAssocSubitemEventId implements Serializable {
    private String orderV2OrderId;

    public String getOrderV2OrderId()
    {
        return this.orderV2OrderId;
    }

    public void setOrderV2OrderId(String orderV2OrderId)
    {
        this.orderV2OrderId = orderV2OrderId;
    }

    private Integer orderShipGroupShipGroupSeqId;

    public Integer getOrderShipGroupShipGroupSeqId()
    {
        return this.orderShipGroupShipGroupSeqId;
    }

    public void setOrderShipGroupShipGroupSeqId(Integer orderShipGroupShipGroupSeqId)
    {
        this.orderShipGroupShipGroupSeqId = orderShipGroupShipGroupSeqId;
    }

    private String orderItemShipGroupAssociationProductId;

    public String getOrderItemShipGroupAssociationProductId()
    {
        return this.orderItemShipGroupAssociationProductId;
    }

    public void setOrderItemShipGroupAssociationProductId(String orderItemShipGroupAssociationProductId)
    {
        this.orderItemShipGroupAssociationProductId = orderItemShipGroupAssociationProductId;
    }

    private Day orderItemShipGroupAssocSubitemDay = new Day();

    public Day getOrderItemShipGroupAssocSubitemDay()
    {
        return this.orderItemShipGroupAssocSubitemDay;
    }

    public void setOrderItemShipGroupAssocSubitemDay(Day orderItemShipGroupAssocSubitemDay)
    {
        this.orderItemShipGroupAssocSubitemDay = orderItemShipGroupAssocSubitemDay;
    }

    private BigInteger version;

    public BigInteger getVersion()
    {
        return this.version;
    }

    public void setVersion(BigInteger version)
    {
        this.version = version;
    }

    protected Integer getOrderItemShipGroupAssocSubitemDayMonthYearNumber()
    {
        return getOrderItemShipGroupAssocSubitemDay().getMonth().getYear().getNumber();
    }

    protected void setOrderItemShipGroupAssocSubitemDayMonthYearNumber(Integer orderItemShipGroupAssocSubitemDayMonthYearNumber)
    {
        getOrderItemShipGroupAssocSubitemDay().getMonth().getYear().setNumber(orderItemShipGroupAssocSubitemDayMonthYearNumber);
    }

    protected String getOrderItemShipGroupAssocSubitemDayMonthYearCalendar()
    {
        return getOrderItemShipGroupAssocSubitemDay().getMonth().getYear().getCalendar();
    }

    protected void setOrderItemShipGroupAssocSubitemDayMonthYearCalendar(String orderItemShipGroupAssocSubitemDayMonthYearCalendar)
    {
        getOrderItemShipGroupAssocSubitemDay().getMonth().getYear().setCalendar(orderItemShipGroupAssocSubitemDayMonthYearCalendar);
    }

    protected Integer getOrderItemShipGroupAssocSubitemDayMonthNumber()
    {
        return getOrderItemShipGroupAssocSubitemDay().getMonth().getNumber();
    }

    protected void setOrderItemShipGroupAssocSubitemDayMonthNumber(Integer orderItemShipGroupAssocSubitemDayMonthNumber)
    {
        getOrderItemShipGroupAssocSubitemDay().getMonth().setNumber(orderItemShipGroupAssocSubitemDayMonthNumber);
    }

    protected Boolean getOrderItemShipGroupAssocSubitemDayMonthIsLeap()
    {
        return getOrderItemShipGroupAssocSubitemDay().getMonth().getIsLeap();
    }

    protected void setOrderItemShipGroupAssocSubitemDayMonthIsLeap(Boolean orderItemShipGroupAssocSubitemDayMonthIsLeap)
    {
        getOrderItemShipGroupAssocSubitemDay().getMonth().setIsLeap(orderItemShipGroupAssocSubitemDayMonthIsLeap);
    }

    protected Integer getOrderItemShipGroupAssocSubitemDayNumber()
    {
        return getOrderItemShipGroupAssocSubitemDay().getNumber();
    }

    protected void setOrderItemShipGroupAssocSubitemDayNumber(Integer orderItemShipGroupAssocSubitemDayNumber)
    {
        getOrderItemShipGroupAssocSubitemDay().setNumber(orderItemShipGroupAssocSubitemDayNumber);
    }

    protected String getOrderItemShipGroupAssocSubitemDayTimeZone()
    {
        return getOrderItemShipGroupAssocSubitemDay().getTimeZone();
    }

    protected void setOrderItemShipGroupAssocSubitemDayTimeZone(String orderItemShipGroupAssocSubitemDayTimeZone)
    {
        getOrderItemShipGroupAssocSubitemDay().setTimeZone(orderItemShipGroupAssocSubitemDayTimeZone);
    }

    public OrderItemShipGroupAssocSubitemEventId()
    {
    }

    public OrderItemShipGroupAssocSubitemEventId(String orderV2OrderId, Integer orderShipGroupShipGroupSeqId, String orderItemShipGroupAssociationProductId, Day orderItemShipGroupAssocSubitemDay, BigInteger version)
    {
        this.orderV2OrderId = orderV2OrderId;
        this.orderShipGroupShipGroupSeqId = orderShipGroupShipGroupSeqId;
        this.orderItemShipGroupAssociationProductId = orderItemShipGroupAssociationProductId;
        this.orderItemShipGroupAssocSubitemDay = orderItemShipGroupAssocSubitemDay;
        this.version = version;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        OrderItemShipGroupAssocSubitemEventId other = (OrderItemShipGroupAssocSubitemEventId)obj;
        return true 
            && (orderV2OrderId == other.orderV2OrderId || (orderV2OrderId != null && orderV2OrderId.equals(other.orderV2OrderId)))
            && (orderShipGroupShipGroupSeqId == other.orderShipGroupShipGroupSeqId || (orderShipGroupShipGroupSeqId != null && orderShipGroupShipGroupSeqId.equals(other.orderShipGroupShipGroupSeqId)))
            && (orderItemShipGroupAssociationProductId == other.orderItemShipGroupAssociationProductId || (orderItemShipGroupAssociationProductId != null && orderItemShipGroupAssociationProductId.equals(other.orderItemShipGroupAssociationProductId)))
            && (orderItemShipGroupAssocSubitemDay == other.orderItemShipGroupAssocSubitemDay || (orderItemShipGroupAssocSubitemDay != null && orderItemShipGroupAssocSubitemDay.equals(other.orderItemShipGroupAssocSubitemDay)))
            && (version == other.version || (version != null && version.equals(other.version)))
            ;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        if (this.orderV2OrderId != null) {
            hash += 13 * this.orderV2OrderId.hashCode();
        }
        if (this.orderShipGroupShipGroupSeqId != null) {
            hash += 13 * this.orderShipGroupShipGroupSeqId.hashCode();
        }
        if (this.orderItemShipGroupAssociationProductId != null) {
            hash += 13 * this.orderItemShipGroupAssociationProductId.hashCode();
        }
        if (this.orderItemShipGroupAssocSubitemDay != null) {
            hash += 13 * this.orderItemShipGroupAssocSubitemDay.hashCode();
        }
        if (this.version != null) {
            hash += 13 * this.version.hashCode();
        }
        return hash;
    }


    protected static final String[] FLATTENED_PROPERTY_NAMES = new String[]{
            "orderV2OrderId",
            "orderShipGroupShipGroupSeqId",
            "orderItemShipGroupAssociationProductId",
            "orderItemShipGroupAssocSubitemDayMonthYearNumber",
            "orderItemShipGroupAssocSubitemDayMonthYearCalendar",
            "orderItemShipGroupAssocSubitemDayMonthNumber",
            "orderItemShipGroupAssocSubitemDayMonthIsLeap",
            "orderItemShipGroupAssocSubitemDayNumber",
            "orderItemShipGroupAssocSubitemDayTimeZone",
            "version",
    };

    protected static final String[] FLATTENED_PROPERTY_TYPES = new String[]{
            "String",
            "Integer",
            "String",
            "Integer",
            "String",
            "Integer",
            "Boolean",
            "Integer",
            "String",
            "BigInteger",
    };

    protected static final java.util.Map<String, String> FLATTENED_PROPERTY_TYPE_MAP;

    static {
        java.util.Map<String, String> m = new java.util.HashMap<String, String>();
        for (int i = 0; i < FLATTENED_PROPERTY_NAMES.length; i++) {
            m.put(FLATTENED_PROPERTY_NAMES[i], FLATTENED_PROPERTY_TYPES[i]);
        }
        FLATTENED_PROPERTY_TYPE_MAP = m;
    }

    protected void forEachFlattenedProperty(java.util.function.BiConsumer<String, Object> consumer) {
        for (int i = 0; i < FLATTENED_PROPERTY_NAMES.length; i++) {
            String pn = FLATTENED_PROPERTY_NAMES[i];
            if (Character.isLowerCase(pn.charAt(0))) {
                pn = Character.toUpperCase(pn.charAt(0)) + pn.substring(1);
            }
            java.lang.reflect.Method m = null;
            try {
                m = this.getClass().getDeclaredMethod("get" + pn, new Class[0]);
            } catch (NoSuchMethodException e) {
                try {
                    m = this.getClass().getMethod("get" + pn, new Class[0]);
                } catch (NoSuchMethodException e1) {
                    throw new RuntimeException(e);
                }
            }
            Object pv = null;
            try {
                pv = m.invoke(this);
            } catch (IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            consumer.accept(pn, pv);
        }
    }

    protected void setFlattenedPropertyValues(Object... values) {
        for (int i = 0; i < FLATTENED_PROPERTY_NAMES.length; i++) {
            String pn = FLATTENED_PROPERTY_NAMES[i];
            if (Character.isLowerCase(pn.charAt(0))) {
                pn = Character.toUpperCase(pn.charAt(0)) + pn.substring(1);
            }
            Object v = values[i];
            Class propCls = v == null ? Object.class : v.getClass();
            java.lang.reflect.Method setterMethod = null;
            if (v == null) {
                setterMethod = getNullValueSetterMethod(pn);
            }
            if (setterMethod == null) {
                try {
                    setterMethod = this.getClass().getDeclaredMethod("set" + pn, new Class[]{propCls});
                } catch (NoSuchMethodException e) {
                    try {
                        setterMethod = this.getClass().getMethod("set" + pn, new Class[]{propCls});
                    } catch (NoSuchMethodException e1) {
                        throw new RuntimeException(e1);
                    }
                }
            }
            try {
                setterMethod.invoke(this, v);
            } catch (IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private java.lang.reflect.Method getNullValueSetterMethod(String pascalPropName) {
        java.lang.reflect.Method m;
        final String methodName = "set" + pascalPropName;
        m = java.util.Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(me -> me.getName().equals(methodName) && me.getParameterCount() == 1)
                .findFirst().orElse(null);
        if (m == null) {
            m = java.util.Arrays.stream(this.getClass().getMethods())
                    .filter(me -> me.getName().equals(methodName) && me.getParameterCount() == 1)
                    .findFirst().orElse(null);
        }
        return m;
    }

}
