package br.ufpb.aps.stephany.exercicio;

import java.util.Scanner;

public class ValidadorEmail implements Validador{
	
	private int max;
	
	public ValidadorEmail(int max){
		this.max = max;
	}
	
	@Override
	public void validar(String valor) throws ValorInvalidoException{
			
		if (valor.length() > max)
				throw new ValorInvalidoException("O tamanho maximo do e-mail eh "+max);
			
		Scanner sc= new Scanner(System.in);
		String email= sc.nextLine();
		
		String a = "@";	
		
		for (int i=0; i> valor.length(); i++){
				if (email.contains(a));
					throw new ValorInvalidoException("E-mail invalido");
		
		}
			//	if (email.indexOf("@")<0){
				//	throw new ValorInvalidoException("E-mail invalido");
					 
			//	}
					

		}
	}


