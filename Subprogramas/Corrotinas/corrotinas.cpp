//C++
//C++20 ou superior tem suporte nativo para co-rotinas com a palavra-chave co_await, co_yield e co_return.

#include <iostream>
#include <coroutine>
#include <chrono>
#include <thread>

using namespace std;

struct Task {
    struct promise_type {
        Task get_return_object() { return {}; }
        suspend_never initial_suspend() { return {}; }
        suspend_never final_suspend() noexcept { return {}; }
        void return_void() {}
        void unhandled_exception() {}
    };
};

Task tarefa1() {
    for (int i = 1; i <= 3; i++) {
        cout << "Tarefa 1 - execução " << i << endl;
        this_thread::sleep_for(chrono::seconds(1));
        co_await suspend_always{};
    }
}

Task tarefa2() {
    for (int i = 1; i <= 2; i++) {
        cout << "Tarefa 2 - execução " << i << endl;
        this_thread::sleep_for(chrono::seconds(2));
        co_await suspend_always{};
    }
}

int main() {
    auto t1 = tarefa1();
    auto t2 = tarefa2();
}
