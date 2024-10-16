# Ruby
# Não suporta sobrecarga de subprogramas diretamente (o último método definido sobrescreve o anterior).
# Uma forma de simular subprogramas sobrecarregados é um único subprograma que filtra o dado

class Sobrecarregado
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

p = Sobrecarregado.new
p.imprimir("Hello")  # imprime a string
p.imprimir(10)       # imprime o inteiro
