package br.ufpb.aps.stephany.exercicio2;

public class ValidadorDecorator implements Validador{
	
	private Validador validador;
	
	public ValidadorDecorator(Validador validar){
		
		this.validador=validar;
		
	}
	
	@Override
	public void validar(String valor) throws ValorInvalidoException {
				
	}

}
