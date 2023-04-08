// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.test.suitestproj1.sui.contract;

public class ContractConstants {
    public static final String DEFAULT_SUI_PACKAGE_NAME = "DEFAULT_SUI_PACKAGE";

    public static final String DAY_SUMMARY_MODULE_DAY_SUMMARY_ID_TABLE = "day_summary::DaySummaryIdTable";

    public static final String DOMAIN_NAME_MODULE_DOMAIN_NAME_ID_TABLE = "domain_name::DomainNameIdTable";

    public static final String ORDER_V2_MODULE_ORDER_ID_TABLE = "order_v2::OrderIdTable";

    public static final String PRODUCT_MODULE_PRODUCT_ID_GENERATOR = "product::ProductIdGenerator";

    public static final String DAY_SUMMARY_MODULE_DAY_SUMMARY_CREATED = "day_summary::DaySummaryCreated";

    public static final String DOMAIN_NAME_MODULE_REGISTERED = "domain_name::Registered";

    public static final String DOMAIN_NAME_MODULE_RENEWED = "domain_name::Renewed";

    public static final String ORDER_MODULE_ORDER_CREATED = "order::OrderCreated";

    public static final String ORDER_MODULE_ORDER_ITEM_REMOVED = "order::OrderItemRemoved";

    public static final String ORDER_MODULE_ORDER_ITEM_QUANTITY_UPDATED = "order::OrderItemQuantityUpdated";

    public static final String ORDER_V2_MODULE_ORDER_V2_CREATED = "order_v2::OrderV2Created";

    public static final String ORDER_V2_MODULE_ORDER_V2_ITEM_REMOVED = "order_v2::OrderV2ItemRemoved";

    public static final String ORDER_V2_MODULE_ORDER_V2_ITEM_QUANTITY_UPDATED = "order_v2::OrderV2ItemQuantityUpdated";

    public static final String ORDER_V2_MODULE_ORDER_V2_ESTIMATED_SHIP_DATE_UPDATED = "order_v2::OrderV2EstimatedShipDateUpdated";

    public static final String ORDER_V2_MODULE_ORDER_SHIP_GROUP_ADDED = "order_v2::OrderShipGroupAdded";

    public static final String ORDER_V2_MODULE_ORDER_SHIP_GROUP_QUANTITY_CANCELED = "order_v2::OrderShipGroupQuantityCanceled";

    public static final String ORDER_V2_MODULE_ORDER_SHIP_GROUP_ITEM_REMOVED = "order_v2::OrderShipGroupItemRemoved";

    public static final String ORDER_V2_MODULE_ORDER_SHIP_GROUP_REMOVED = "order_v2::OrderShipGroupRemoved";

    public static final String PRODUCT_MODULE_PRODUCT_CREATED = "product::ProductCreated";


    public static String[] getMoveObjectIdGeneratorObjectTypes(String packageId) {
        return new String[]{
                packageId + "::" + DAY_SUMMARY_MODULE_DAY_SUMMARY_ID_TABLE,
                packageId + "::" + DOMAIN_NAME_MODULE_DOMAIN_NAME_ID_TABLE,
                packageId + "::" + ORDER_V2_MODULE_ORDER_ID_TABLE,
                packageId + "::" + PRODUCT_MODULE_PRODUCT_ID_GENERATOR,
        };
    }
}
