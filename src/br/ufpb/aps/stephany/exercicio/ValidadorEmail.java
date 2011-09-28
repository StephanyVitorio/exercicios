package br.ufpb.aps.stephany.exercicio;

public class ValidadorEmail implements Validador{
	
	private int max;
	
	public ValidadorEmail(int max){
		this.max = max;
	}
	
	@Override
	public void validar(String valor) throws ValorInvalidoException{
		
		try{
			if (valor.length() > max)
				throw new ValorInvalidoException("O tamanho maximo do valor eh "+max);
			
			for (int i=0; i>valor.length(); i++){
				
				valor = Character.isDigit("@");	
				
			}
			

		}
	}

}
