package br.ufpb.aps.stephany.exercicio;

public class ValidadorNumerico implements Validador {

	private int min = 0;
	private int max = 150;

	@Override
	public void validar(String valor) throws ValorInvalidoException {
		 try {
			int v  = Integer.parseInt(valor);
		

		if (v < min) {
			throw new ValorInvalidoException("valor eh minimo de idade eh "
					+ min);
		}

		if (v > max) {
			throw new ValorInvalidoException("valor maximo de idade eh " + max);
		}
		 
		 }catch (NumberFormatException e) {
				throw new ValorInvalidoException("Digite um valor inteiro");
			}
	}
}
