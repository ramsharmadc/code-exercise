pub mod primary_concepts {

    pub fn add(a: i32, b: i32) -> i32 {
        println!("adding {} {}", a, b);
        a + b
    }

    pub fn mulitply(a: f32, b: f32) -> f32 {
        println!("multiplying {} {}", a, b);
        println!("(a*b) = {}", (a * b));
        a * b
    }
}
