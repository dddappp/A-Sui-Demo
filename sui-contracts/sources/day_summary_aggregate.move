// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module sui_test_proj1::day_summary_aggregate {
    use std::option::Option;
    use std::string::String;
    use sui::tx_context;
    use sui_test_proj1::day::{Self, Day};
    use sui_test_proj1::day_summary;
    use sui_test_proj1::day_summary_create_logic;
    use sui_test_proj1::month;
    use sui_test_proj1::year;

    public entry fun create(
        day_month_year_number: u16,
        day_month_year_calendar: String,
        day_month_number: u8,
        day_month_is_leap: bool,
        day_number: u8,
        day_time_zone: String,
        description: String,
        meta_data: vector<u8>,
        array_data: vector<String>,
        optional_data: Option<vector<u8>>,
        day_summary_id_table: &mut day_summary::DaySummaryIdTable,
        ctx: &mut tx_context::TxContext,
    ) {
        let day: Day = day::new(
            month::new(
                year::new(
                    day_month_year_number,
                    day_month_year_calendar,
                ),
                day_month_number,
                day_month_is_leap,
            ),
            day_number,
            day_time_zone,
        );

        let day_summary_created = day_summary_create_logic::verify(
            day,
            description,
            meta_data,
            array_data,
            optional_data,
            day_summary_id_table,
            ctx,
        );
        let day_summary = day_summary_create_logic::mutate(
            &day_summary_created,
            day_summary_id_table,
            ctx,
        );
        day_summary::set_day_summary_created_id(&mut day_summary_created, day_summary::id(&day_summary));
        day_summary::transfer_object(day_summary, tx_context::sender(ctx));
        day_summary::emit_day_summary_created(day_summary_created);
    }

}
