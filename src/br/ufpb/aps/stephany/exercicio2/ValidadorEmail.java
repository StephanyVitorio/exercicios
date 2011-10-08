package br.ufpb.aps.stephany.exercicio2;

public class ValidadorEmail implements Validador {

	private int max = 200;

	@Override
	public void validar(String valor) throws ValorInvalidoException {
		if (valor.length() > max)
			throw new ValorInvalidoException("O tamanho maximo do e-mail eh "
					+ max);
		String a="@";
		if (!valor.contains(a))
			throw new ValorInvalidoException("E-mail invalido");

		int cont = 0;
		
		for (int i = 0; i < valor.length() ; i++) {
			if ('@'==(valor.charAt(i))) {
				cont++;
			}
		}
		if (cont > 1) {
			throw new ValorInvalidoException("Não pode ter mais de uma  @");

		}
		if ('@'==(valor.charAt(0))) {
			throw new ValorInvalidoException("@ nao pode no inicio ");
		}
		if ('@'==(valor.charAt(valor.length() - 1))) {
			throw new ValorInvalidoException("@ nao pode no fim ");
		}

	}

}
