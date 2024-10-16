# Ruby
# Não suporta sobrecarga de subprogramas diretamente (o último método definido sobrescreve o anterior).
# Uma forma de simular subprogramas polimorficos é um único subprograma que filtra o dado

class Polimorfismo
  def imprimir(value)
    if value.is_a?(String)
      puts value
    elsif value.is_a?(Integer)
      puts value
    else
      puts "Tipo desconhecido"
    end
  end
end

p = Polimorfismo.new
p.imprimir("Hello")  # imprime a string
p.imprimir(10)       # imprime o inteiro
