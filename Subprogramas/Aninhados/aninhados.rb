# Ruby
def metodo_externo
  puts "Este é o método externo."

  def metodo_interno
    puts "Este é o método interno."
  end

  metodo_interno  # Chama o método interno
end

metodo_externo  # Chama o método externo
