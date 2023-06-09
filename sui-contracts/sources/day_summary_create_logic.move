module sui_test_proj1::day_summary_create_logic {
    use std::option::Option;
    use std::string::String;

    use sui::tx_context::TxContext;
    use sui_test_proj1::day::Day;
    use sui_test_proj1::day_summary;
    use sui_test_proj1::day_summary_created;

    friend sui_test_proj1::day_summary_aggregate;

    public(friend) fun verify(
        day: Day,
        description: String,
        meta_data: vector<u8>,
        array_data: vector<String>,
        optional_data: Option<vector<u8>>,
        day_summary_id_table: &day_summary::DaySummaryIdTable,
        ctx: &mut TxContext,
    ): day_summary::DaySummaryCreated {
        let _ = ctx;
        day_summary::asset_day_not_exists(day, day_summary_id_table);
        day_summary::new_day_summary_created(
            day,
            description,
            meta_data,
            array_data,
            optional_data,
        )
    }

    public(friend) fun mutate(
        day_summary_created: &day_summary::DaySummaryCreated,
        day_summary_id_table: &mut day_summary::DaySummaryIdTable,
        ctx: &mut TxContext,
    ): day_summary::DaySummary {
        let day_summary = day_summary::create_day_summary(
            day_summary_created::day(day_summary_created),
            day_summary_created::description(day_summary_created),
            day_summary_created::meta_data(day_summary_created),
            day_summary_created::array_data(day_summary_created),
            day_summary_created::optional_data(day_summary_created),
            day_summary_id_table,
            ctx,
        );
        day_summary
    }
}
