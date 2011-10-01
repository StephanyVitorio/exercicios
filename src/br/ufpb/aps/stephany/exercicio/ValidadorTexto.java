package br.ufpb.aps.stephany.exercicio;

public class ValidadorTexto implements Validador {

	private int max = 30;

/**	public ValidadorTexto() {

	}*/

	@Override
	public void validar(String valor) throws ValorInvalidoException {
		if (valor.length() > max) {
			throw new ValorInvalidoException("O tamanho maximo de caracteres eh " + max);

		}
		for (int i = 0; i < valor.length(); i++) {
			if (Character.isDigit(valor.charAt(i))) {
				throw new ValorInvalidoException("nome eh um campo texto nao pode ter numero");
			}
		}

	

	}

}
