// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module sui_test_proj1::order_aggregate {
    use std::string::String;
    use sui::tx_context;
    use sui_test_proj1::order;
    use sui_test_proj1::order_create_logic;
    use sui_test_proj1::order_remove_item_logic;
    use sui_test_proj1::order_update_item_quantity_logic;
    use sui_test_proj1::product::Product;

    public entry fun create(
        product: &Product,
        quantity: u64,
        ctx: &mut tx_context::TxContext,
    ) {
        let order_created = order_create_logic::verify(
            product,
            quantity,
            ctx,
        );
        let order = order_create_logic::mutate(
            &order_created,
            ctx,
        );
        order::set_order_created_id(&mut order_created, order::id(&order));
        order::transfer_object(order, order::order_created_owner(&order_created));
        order::emit_order_created(order_created);
    }


    public entry fun remove_item(
        order: order::Order,
        product_id: String,
        ctx: &mut tx_context::TxContext,
    ) {
        let order_item_removed = order_remove_item_logic::verify(
            product_id,
            &order,
            ctx,
        );
        let updated_order = order_remove_item_logic::mutate(
            &order_item_removed,
            order,
            ctx,
        );
        order::update_version_and_transfer_object(updated_order, tx_context::sender(ctx));
        order::emit_order_item_removed(order_item_removed);
    }


    public entry fun update_item_quantity(
        order: order::Order,
        product_id: String,
        quantity: u64,
        ctx: &mut tx_context::TxContext,
    ) {
        let order_item_quantity_updated = order_update_item_quantity_logic::verify(
            product_id,
            quantity,
            &order,
            ctx,
        );
        let updated_order = order_update_item_quantity_logic::mutate(
            &order_item_quantity_updated,
            order,
            ctx,
        );
        order::update_version_and_transfer_object(updated_order, tx_context::sender(ctx));
        order::emit_order_item_quantity_updated(order_item_quantity_updated);
    }

}