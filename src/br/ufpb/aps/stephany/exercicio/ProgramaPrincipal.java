package br.ufpb.aps.stephany.exercicio;

import javax.swing.JOptionPane;


public class ProgramaPrincipal {
	public String menu() {
		String menu = "Sistema de Cadastro\n" + "[1]- Cadastrar\n"
				+ "[2]- Listar itens Cadastrados\n" + "[3]-Sair";

		return JOptionPane.showInputDialog(menu);
	}

	public String menu2() {
		String menu2 = "Cadastro Finalizado \n" + "[C]- Continua "
				+ "[F]- Finaliza \n ";

		return JOptionPane.showInputDialog(menu2);

	}

	FormularioFacade facade = new FormularioFacade();

	// Campo c= new Campo("");

	public void executar() {

		int opcao1 = Integer.parseInt(menu());
		while (opcao1 != 3) {
			switch (opcao1) {
			case 1:
				obterdados();
				break;
			case 2:
				facade.listarItens();
				break;
			}
			opcao1 = Integer.parseInt(menu());
		}
		JOptionPane.showMessageDialog(null, "Até logo!");
	}

	public void obterdados() {

		int op = 1;

		if (op == 1) {
			String opcao2 = "c";

			while (opcao2.equalsIgnoreCase("c")) {

				String nomep;
				Campo campotexto = new Campo(Campo.NOME, "Nome", null);

				
				while (true) {
					try {

						nomep = JOptionPane
								.showInputDialog("Digite o seu nome");
						campotexto.setValor(nomep);
						campotexto.validar();
						break;
					} catch (ValorInvalidoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}

				}

				String email ;
				Campo campoemail = new Campo(Campo.EMAIL, "E-mail", null);

				
				while (true) {
					try {

						email = JOptionPane
								.showInputDialog("Digite o seu Email");
						campoemail.setValor(email);
						campoemail.validar();
						break;

					} catch (ValorInvalidoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}

				String idade;
				Campo campoidade = new Campo(Campo.IDADE, "Idade", null);
				campoidade.setValidador(new ValidadorNumerico());

				
				while (true) {
					try {

						idade = JOptionPane
								.showInputDialog("Digite o sua idade");
						campoidade.setValidador(new ValidadorNumerico());
						campoidade.setValor(idade);
						campoidade.validar();
						break;
					} catch (ValorInvalidoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}

				}

				

				facade.addCampo(campotexto);
				facade.addCampo(campoemail);
				facade.addCampo(campoidade);
				

				opcao2 = menu2();
				if (opcao2.equalsIgnoreCase("f"))
					break;
			}

			return;
		}

	}

	public static void main(String[] args) {
		ProgramaPrincipal p = new ProgramaPrincipal();
		p.executar();

	}

		
}
