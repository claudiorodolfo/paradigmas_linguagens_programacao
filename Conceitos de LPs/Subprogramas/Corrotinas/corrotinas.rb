# Ruby 

fiber1 = Fiber.new do
    3.times do |i|
        puts "Tarefa 1 - execução #{i + 1}"
        sleep(1)
        Fiber.yield
    end
end

fiber2 = Fiber.new do
    2.times do |i|
        puts "Tarefa 2 - execução #{i + 1}"
        sleep(2)
        Fiber.yield
    end
end

fiber1.resume
fiber2.resume
fiber1.resume
fiber2.resume
fiber1.resume
