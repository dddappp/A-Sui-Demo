module sui_test_proj1::order_create_logic {
    use sui::tx_context::{Self, TxContext};
    use sui_test_proj1::order;
    use sui_test_proj1::order_created;
    use sui_test_proj1::order_item;
    use sui_test_proj1::product::{Self, Product};

    friend sui_test_proj1::order_aggregate;

    public(friend) fun verify(
        product: &Product,
        quantity: u64,
        ctx: &mut TxContext,
    ): order::OrderCreated {
        //let id = object::new(ctx);
        let e_quantity = quantity;
        let e_owner = tx_context::sender(ctx);
        let unit_price = product::unit_price(product);
        //(
        order::new_order_created(
            //&id,
            product::product_id(product),
            e_quantity,
            unit_price,
            unit_price * (e_quantity as u128),
            e_owner,
        )//,
        //id,
        //)
    }

    public(friend) fun mutate(
        order_created: &order::OrderCreated,
        ctx: &mut TxContext,
    ): order::Order {
        let order = order::new_order(
            order::order_created_total_amount(order_created),
            ctx,
        );
        let order_item = order_item::new_order_item(
            order_created::product(order_created),
            order_created::quantity(order_created),
            order_created::unit_price(order_created) * (order_created::quantity(order_created) as u128),
            //ctx,
        );
        order::add_item(&mut order, order_item);
        order
    }
}
