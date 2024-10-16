//JavaScript

function esperar(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function tarefa1() {
    for (let i = 0; i < 3; i++) {
        console.log(`Tarefa 1 - execução ${i + 1}`);
        await esperar(1000);
    }
}

async function tarefa2() {
    for (let i = 0; i < 2; i++) {
        console.log(`Tarefa 2 - execução ${i + 1}`);
        await esperar(2000);
    }
}

async function main() {
    await Promise.all([tarefa1(), tarefa2()]);
}

main();
