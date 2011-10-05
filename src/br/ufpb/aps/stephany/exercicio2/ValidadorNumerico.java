package br.ufpb.aps.stephany.exercicio2;


public class ValidadorNumerico implements Validador {

	

	@Override
	public void validar(String valor) throws ValorInvalidoException {
		 try {
			int v  = Integer.parseInt(valor);
		

		 } catch (NumberFormatException e) {
				throw new ValorInvalidoException("Digite um valor inteiro");
			}
	}
}
