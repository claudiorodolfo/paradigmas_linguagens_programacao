#Ruby

def print_numbers(*numbers)
  numbers.each { |number| puts number }
end

# Chama o método com parâmetros variávei
print_numbers(1, 2, 3, 4, 5)  