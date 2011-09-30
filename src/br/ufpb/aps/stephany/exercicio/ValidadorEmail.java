package br.ufpb.aps.stephany.exercicio;

import java.util.Scanner;

public class ValidadorEmail implements Validador{
	
	private int max=200;
	
	public ValidadorEmail(){
		
	}
	
	@Override
	public void validar(String valor) throws ValorInvalidoException{
			
		if (valor.length() > max)
				throw new ValorInvalidoException("O tamanho maximo do e-mail eh "+max);
			
		Scanner sc= new Scanner(System.in);
		String email= sc.nextLine();
		
		String a = "@";	
		
			if (email.contains(a));
					throw new ValorInvalidoException("E-mail invalido");
						

		}
	}


