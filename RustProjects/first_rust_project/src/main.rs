extern crate core;

use crate::basic_concepts::basic_concepts::basics;
use crate::basic_concepts::basic_concepts::check_enum;
use crate::basic_concepts::basic_concepts::conditional_operators;
use crate::basic_concepts::basic_concepts::create_integers;
use crate::basic_concepts::basic_concepts::greeting;
use crate::basic_concepts::basic_concepts::rounding_off_floats;
use crate::basic_concepts::basic_concepts::string_basics;
use crate::basic_concepts::basic_concepts::text_parsing;
use crate::primary_concepts::primary_concepts::add;
use crate::primary_concepts::primary_concepts::divide;
use crate::primary_concepts::primary_concepts::multiply;
use crate::primary_concepts::primary_concepts::subtract;
use crate::primary_concepts::primary_concepts::complex_numbers;

mod basic_concepts;
mod primary_concepts;

fn main() {
    println!("Starting Rust execution - Hello, Rust!");
    basics();
    greeting();
    text_parsing();
    string_basics();
    check_enum();
    conditional_operators();
    create_integers();
    rounding_off_floats();

    // from primary concepts module
    add(34, 89);
    multiply(93.5, 76.5);
    divide(90, 5);
    divide(9,0);
    subtract(98,8);
    subtract(9, 98);
    complex_numbers();
}
