package br.ufpb.aps.stephany.exercicio2;


public class ValidadorNomeDecorator extends ValidadorDecorator {

	public ValidadorNomeDecorator(Validador validar) {
		super(validar);
		
	}

	private int max = 300;
	private int min = 5;

	@Override
	public void validar(String valor) throws ValorInvalidoException {
		
		if (valor.length() > max) {
			throw new ValorInvalidoException("O tamanho maximo de caracteres eh " + max);

		}
		
		if (valor.length() < min){
			throw new ValorInvalidoException("O tamanho minimo de caracteres eh " + min);
			
		}
		
		
		
	}

}
