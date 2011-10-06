package br.ufpb.aps.stephany.exercicio3;

public class CustoAquisicaoDecorator extends CalculadorCustoDecorator{

	
	public Double valor;
	public String nome;
	
	public CustoAquisicaoDecorator(CalculadorCusto custo) {
		super(custo);
	}

	@Override
	public Double getPreco() {
		return valor+custo.getPreco();
	}
	
	public void setPreco(double valor){
		this.valor=valor;
	}
	
	public String getTipo() {
		return nome+","+custo.getTipo();
	}
	
	public void setTipo(String nome){
		this.nome= nome;
	}
	
	
	

	
}
