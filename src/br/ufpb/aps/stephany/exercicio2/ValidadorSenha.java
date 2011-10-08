package br.ufpb.aps.stephany.exercicio2;

public class ValidadorSenha implements Validador {

	

	private int max = 100;
	private int min = 8;

	@Override
	public void validar(String valor) throws ValorInvalidoException {
		
				
		if (valor.length() > max) {
			throw new ValorInvalidoException("O tamanho maximo da senha eh"
					+ max);

		}

		if (valor.length() < min) {
			throw new ValorInvalidoException("O tamanho minimo da senha eh "
					+ min);
		}
	}

}
