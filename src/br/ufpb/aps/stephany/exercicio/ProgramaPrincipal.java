package br.ufpb.aps.stephany.exercicio;

import javax.swing.JOptionPane;

public class ProgramaPrincipal {

	public String menu(){
			String menu= "Sistema de Cadastro\n" + "[1]- Cadastrar\n" + 
		"[2]- Listar itens Cadastrados\n"+"[3]-Sair";
			
			return JOptionPane.showInputDialog(menu);
		
	}
}
