package br.ufpb.aps.stephany.exercicio2;

public class ValidadorSenhaTextoDecorator extends ValidadorDecorator {

	public ValidadorSenhaTextoDecorator(Validador validador) {
		super(validador);
		
	}
	public void validar(String valor)throws ValorInvalidoException{
		validador.validar(valor);
		
		int contNumeros = 0;
		for (char a : valor.toCharArray()) {
			if (Character.isDigit(a)) {
				contNumeros++;

			}

		}
		if (contNumeros< 3){
			throw new ValorInvalidoException("Não pode ter menos que 3 numeros");
		}


	}
	
}
