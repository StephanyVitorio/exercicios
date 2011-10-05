package br.ufpb.aps.stephany.exercicio2;


public class ValidadorTexto implements Validador {

	
	@Override
	public void validar(String valor) throws ValorInvalidoException {
		
				
		for (int i = 0; i < valor.length(); i++) {
			if (Character.isDigit(valor.charAt(i))) {
				throw new ValorInvalidoException("nome eh um campo texto nao pode ter numero");
			}
		}

	

	}

}
