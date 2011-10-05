package br.ufpb.aps.stephany.exercicio2;


public class ValidadorEmail implements Validador {

	private int max = 200;

	@Override
	public void validar(String valor) throws ValorInvalidoException{
		if (valor.length() > max){
			throw new ValorInvalidoException("O tamanho maximo do e-mail eh "+max);
		}		
		String a = "@";	
		int cont= 0;
		
			if (!valor.contains(a)){
					throw new ValorInvalidoException("E-mail invalido");
			}
			
			for (int i =0; i<valor.length(); i++){
				if (a.equals(valor.charAt(i))){
					cont++;
				}
				
			}
			
			if(a.equals(valor.charAt(0))){
				throw new ValorInvalidoException("Nao pode iniciar com @");
			}
			
			if(a.equals(valor.charAt(valor.length()))){
				throw new ValorInvalidoException("Nao pode terminar com @");
			}
			
		}
}
