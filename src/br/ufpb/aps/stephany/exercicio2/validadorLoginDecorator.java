package br.ufpb.aps.stephany.exercicio2;

public class validadorLoginDecorator extends ValidadorDecorator {
	private int max = 20;
	private int min = 1;

	public validadorLoginDecorator(Validador validador) {
		super(validador);
	}

	public void validar(String valor) throws ValorInvalidoException {
		
		validador.validar(valor);
		
		if (valor.length() > max) {
			throw new ValorInvalidoException("O tamanho maximo do login eh "
					+ max);
		}
		if (valor.length() < min) {
			throw new ValorInvalidoException("O tamanho minimo do login eh"
					+ min);
		}
	}

}
