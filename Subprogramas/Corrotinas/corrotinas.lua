//Lua

function tarefa1()
    for i = 1, 3 do
        print("Tarefa 1 - execução " .. i)
        coroutine.yield(os.execute("sleep " .. 1))
    end
end

function tarefa2()
    for i = 1, 2 do
        print("Tarefa 2 - execução " .. i)
        coroutine.yield(os.execute("sleep " .. 2))
    end
end

co1 = coroutine.create(tarefa1)
co2 = coroutine.create(tarefa2)

coroutine.resume(co1)
coroutine.resume(co2)
coroutine.resume(co1)
coroutine.resume(co2)
coroutine.resume(co1)
