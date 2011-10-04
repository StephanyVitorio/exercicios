package br.ufpb.aps.stephany.exercicio2;

public class ValidadorEmail implements Validador {

	private int max = 200;

	@Override
	public void validar(String valor) throws ValorInvalidoException{
		if (valor.length() > max)
			throw new ValorInvalidoException("O tamanho maximo do e-mail eh "+max);
			
		
		String a = "@";	
		
			if (!valor.contains(a))
					throw new ValorInvalidoException("E-mail invalido");
						

		}
}
