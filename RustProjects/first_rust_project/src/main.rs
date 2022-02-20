mod basic_concepts;
mod primary_concepts;

use crate::basic_concepts::basic_concepts::basics;
use crate::basic_concepts::basic_concepts::check_enum;
use crate::basic_concepts::basic_concepts::conditional_operators;
use crate::basic_concepts::basic_concepts::create_integers;
use crate::basic_concepts::basic_concepts::greeting;
use crate::basic_concepts::basic_concepts::string_basics;
use crate::basic_concepts::basic_concepts::text_parsing;

use crate::primary_concepts::primary_concepts::add;
use crate::primary_concepts::primary_concepts::mulitply;

fn main() {
    println!("Hello, Rust!");
    basics();
    greeting();
    text_parsing();
    string_basics();
    check_enum();
    conditional_operators();
    create_integers();

    // from primary concepts module
    add(34, 89);
    mulitply(93.5, 76.5);
}
