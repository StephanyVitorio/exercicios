package br.ufpb.aps.stephany.exercicio2;

import javax.swing.JOptionPane;

public class ProgramaPrincipal {

	FormularioFacade facade = new FormularioFacade();

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
				String email;
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
				String login;
				Campo campoLogin = new Campo(Campo.LOGIN, "login", null);
				campoLogin.setValidador(new validadorLoginDecorator(
						new ValidadorTexto()));

				while (true) {
					try {

						login = JOptionPane
								.showInputDialog("Digite o seu login");
						campoLogin.setValidador(new validadorLoginDecorator(
								new ValidadorTexto()));
						campoLogin.setValor(login);
						campoLogin.validar();
						break;
					} catch (ValorInvalidoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}

				}

				String senhaNumerica;
				Campo senhaN = new Campo(Campo.SENHANUMERICA, "SENHA", null);
				campoLogin.setValidador(new ValidadorSenhaNumericaDecorator(
						new ValidadorSenha()));

				while (true) {
					try {

						senhaNumerica = JOptionPane
								.showInputDialog("Digite o sua senha numerica");
						senhaN.setValidador(new ValidadorSenhaNumericaDecorator(
								new ValidadorNumerico()));
						senhaN.setValor(senhaNumerica);
						senhaN.validar();
						break;
					} catch (ValorInvalidoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}

				}

				String senhaTexto = "";
				Campo senhaT = new Campo(Campo.SENHATEXTO, "SENHA", null);
				campoLogin.setValidador(new ValidadorSenhaTextoDecorator(
						new ValidadorSenha()));

				while (true) {
					try {

						senhaTexto = JOptionPane
								.showInputDialog("Digite a sua senha texto");
						senhaT.setValidador(new ValidadorSenhaTextoDecorator(
								new ValidadorSenha()));
						senhaT.setValor(senhaTexto);
						senhaT.validar();
						break;
					} catch (ValorInvalidoException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}

				}

				facade.addCampo(campotexto);
				facade.addCampo(campoemail);
				facade.addCampo(campoidade);
				facade.addCampo(campoLogin);
				facade.addCampo(senhaT);
				facade.addCampo(senhaN);

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
