package br.ufpb.aps.stephany.exercicio2;

public class ValidadorTexto implements Validador {

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
		for (int i = 0; i < valor.length(); i++) {
			if (Character.isDigit(valor.charAt(i))) {
				throw new ValorInvalidoException("nome eh um campo texto nao pode ter numero");
			}
		}

	

	}

}
