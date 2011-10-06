package br.ufpb.aps.stephany.exercicio3;

public class CustoFuncionarioDecorator extends CalculadorCustoDecorator{

	public Double valor;
	public String nome;
	
	public CustoFuncionarioDecorator(CalculadorCusto custo) {
		super(custo);
		
	}
	
	public Double getPreco(){
		return valor+custo.getPreco();
	}
	
	public void setPreco(Double preco){
		this.valor = preco;
	}

	public String getTipo() {
		return nome+","+custo.getTipo();
	}

	public void setTipo(String a) {
		this.nome = a;
	}
	
	
}
