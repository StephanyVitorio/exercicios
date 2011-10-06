package br.ufpb.aps.stephany.exercicio3;

public class CalculadorCustoDecorator implements CalculadorCusto{

	protected CalculadorCusto custo;
	
	public CalculadorCustoDecorator (CalculadorCusto custo){
		this.custo = custo;
	}

	@Override
	public Double getPreco() {
		return custo.getPreco();
	}

	@Override
	public String getTipo() {
		return custo.getTipo();
	}

	
	
	
	
	

}
