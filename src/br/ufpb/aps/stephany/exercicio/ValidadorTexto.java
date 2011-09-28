package br.ufpb.aps.stephany.exercicio;


public class ValidadorTexto implements Validador {

	private int max;
	
	public ValidadorTexto(int max){
		this.max = max;
	}
	
	@Override
	public void validar(String valor) throws ValorInvalidoException{
		if (valor.length() > max)
			throw new ValorInvalidoException("O tamanho maximo do valor eh "+max);

	}

}

