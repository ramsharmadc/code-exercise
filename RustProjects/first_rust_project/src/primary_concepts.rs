// use num::complex::Complex;

pub mod primary_concepts {
    use num::complex::Complex;

    pub fn add(a: i32, b: i32) -> i32 {
        println!("adding {} {}", a, b);
        a + b
    }

    pub fn multiply(a: f32, b: f32) -> f32 {
        println!("multiplying {} {}", a, b);
        println!("(a*b) = {}", (a * b));
        a * b
    }

    pub fn divide(a: i32, b: i32) {
        print!("Dividing {} by {} -> ", a, b);
        let mut c = 0;
        if b == 0 {
            eprintln!("{}", "can not divide by zero");
            return;
        }
        c = a / b;
    }

    pub fn subtract(a: i32, b: i32) {
        println!("Subtracting {} from {}", b, a);
        if a < (b as i32) {
            println!("can not subtract {} is less than {}", a, b);
        }
        let b_: i32 = b.try_into().unwrap();
        println!("b.try_into().unwrap() {}", b_);
        a - b;
    }

    pub fn complex_numbers() {
        println!("Working with complex numbers");
        let a = Complex { re: 2.1, im: -1.2 };
        let b = Complex::new(11.1, 22.2);
        let result = a + b;

        println!("Complex operation resulted in {}", result);

    }
}
