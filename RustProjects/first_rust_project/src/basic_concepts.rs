pub mod basic_concepts {

    use std::{
        rc::Rc,
        sync::{Arc, Mutex},
    };

    #[derive(Debug)]
    enum Cereal {
        Barley,
        Millet,
        Rice,
        Rye,
        Spelt,
        Wheat,
    }

    pub fn check_enum() {
        let mut grains: Vec<Cereal> = vec![];
        grains.push(Cereal::Rice);
        grains.push(Cereal::Barley);
        grains.push(Cereal::Millet);
        grains.push(Cereal::Rye);
        grains.push(Cereal::Spelt);
        grains.push(Cereal::Wheat);
        // drop(grains);  // at this point grains become dangling
        println!();
        println!("{:?}", grains);
    }

    pub fn basics() {
        println!("Server side programming is best with Rust");
        let a = 34;
        let b = a * a;
        println!("Value of b is {}", b);
    }

    pub fn greeting() {
        let regions = ["southeast", "uscentral"];
        for region in regions.iter() {
            println!("{}&{}", &region, region.len())
        }
    }

    pub fn text_parsing() {
        let penguin_data = "\
    common name,length(cm)
    Little Penguin,33
    Yellow-eyed penguin,65
    Fiordland penguin,60
    Invalid,data
    ";

        let records = penguin_data.lines();

        for (i, record) in records.enumerate() {
            if i == 0 || record.trim().len() == 0 {
                continue;
            }
            let fields: Vec<_> = record.split(',').map(|field| field.trim()).collect();
            if cfg!(debug_assertions) {
                eprintln!("Debug: {:?} -> {:?}", record, fields);
            }
            let name = fields[0];
            if let Ok(length) = fields[1].parse::<f32>() {
                println!("Info: {}, {}cm", &name, length);
            } else {
                eprintln!("Info: wrong number in record {:?} {:?}", &name, fields[1]);
            }
            println!("{}", "parsing finished")
        }
    }

    pub fn string_basics() {
        let s: &str = "Rust is something";
        for c in s.chars() {
            print!("{} ", c);
        }
    }

    pub fn conditional_operators() {
        let mut a = 10;
        assert_eq!(a + 10, 20);
        a += 1;
        if a == 11 {
            println!("a grown up to {}", a)
        }
    }

    pub fn create_integers() {
        let a = 10;
        let b = Box::new(20);
        let c = Rc::new(Box::new(30));
        let d = Arc::new(Mutex::new(40));
        println!("a={:?},b={:?},c={:?},d={:?}", a, b, c, d)
    }
}
