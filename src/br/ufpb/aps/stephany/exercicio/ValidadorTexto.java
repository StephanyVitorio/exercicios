package br.ufpb.aps.stephany.exercicio;

import java.util.Scanner;


public class ValidadorTexto implements Validador {

	private int max=30;
	
	public ValidadorTexto(){
	
	}
	
	@Override
	public void validar(String valor) throws ValorInvalidoException{
			Scanner sc= new Scanner(System.in);
			String nome= sc.nextLine();
			
			for (int i=0; i> valor.length(); i++){
				
				if (Character.isDigit(nome.charAt(i)));
				throw new ValorInvalidoException("nome eh um campo texto nao pode ter numero");
			
			}
		if (valor.length() > max)
				throw new ValorInvalidoException("O tamanho maximo de caracteres eh "+max);
		
		
			
		}

}

