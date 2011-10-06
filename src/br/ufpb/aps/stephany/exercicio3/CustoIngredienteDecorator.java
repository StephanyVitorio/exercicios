package br.ufpb.aps.stephany.exercicio3;

public class CustoIngredienteDecorator extends CalculadorCustoDecorator{

	public Double valor;
	public String tipo;
	
	public CustoIngredienteDecorator(CalculadorCusto custo) {
		super(custo);
		
	}
	
	public Double getPreco(){
		return valor+custo.getPreco();
	}
	
	public String getTipo() {
		return tipo+","+ custo.getTipo();
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

		
	public void setPreco(Double preco){
		this. valor = preco;
	}
}
