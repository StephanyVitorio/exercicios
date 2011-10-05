package br.ufpb.aps.stephany.exercicio2;


public class ValidadorLoginDecorator extends ValidadorDecorator{

	public ValidadorLoginDecorator(Validador validar) {
		super(validar);
		
	}


	private int max = 20;
	private int min = 0;
	
	
	public void validar(String valor) throws ValorInvalidoException{
			if (valor.length() > max){
				throw new ValorInvalidoException("O tamanho maximo do login eh "+max);
			}
			
			if(valor.length() <= min){
				throw new ValorInvalidoException("O login nao pode ser vazio");
			}
			
			
	}
}
