package br.ufpb.aps.stephany.exercicio2;


public class ValidadorIdadeDecorator extends ValidadorDecorator {

	public ValidadorIdadeDecorator(Validador validar) {
		super(validar);
		
	}

	private int min = 0;
	private int max = 150;

	@Override
	public void validar(String valor) throws ValorInvalidoException {
		
			int v  = Integer.parseInt(valor);
		

			if (v < min) {
				throw new ValorInvalidoException("valor eh minimo de idade eh "
						+ min);
			}

			if (v > max) {
				throw new ValorInvalidoException("valor maximo de idade eh " + max);
			}
		 } 
	}

