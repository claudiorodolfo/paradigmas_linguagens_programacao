//Rust

use tokio::time::{sleep, Duration};

async fn tarefa1() {
    for i in 0..3 {
        println!("Tarefa 1 - execução {}", i + 1);
        sleep(Duration::from_secs(1)).await;
    }
}

async fn tarefa2() {
    for i in 0..2 {
        println!("Tarefa 2 - execução {}", i + 1);
        sleep(Duration::from_secs(2)).await;
    }
}

#[tokio::main]
async fn main() {
    tokio::join!(tarefa1(), tarefa2());
}
