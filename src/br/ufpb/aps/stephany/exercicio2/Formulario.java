package br.ufpb.aps.stephany.exercicio2;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Formulario {

	private List<Campo> campos;

	public Formulario() {
		this.campos = new LinkedList<Campo>();
	}

	public void addCampo(Campo campo) {
		this.campos.add(campo);
	}

	public String listarItens() {
		String retorno = "";
		for (Campo c : campos) {
			retorno += "\n" + c.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, retorno);
		return retorno;
	}

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
				listarItens();
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

				String nomep = JOptionPane.showInputDialog("Digite o seu nome");
				Campo campotexto = new Campo(Campo.NOME, "Nome", nomep);

				while (campotexto.validar() == false) {
					nomep = JOptionPane.showInputDialog("Digite o seu nome");
					campotexto.setValor(nomep);

				}

				String email = JOptionPane.showInputDialog("Digite seu E-mail");
				Campo campoemail = new Campo(Campo.EMAIL, "E-mail", email);

				while (campoemail.validar() == false) {
					email = JOptionPane.showInputDialog("Digite o seu Email");
					campoemail.setValor(email);
				}

				String idade = JOptionPane.showInputDialog("Digite sua idade");
				Campo campoidade = new Campo(Campo.IDADE, "Idade", idade);
				campoidade.setValidador(new ValidadorNumerico());

				while (campoidade.validar() == false) {
					idade = JOptionPane.showInputDialog("Digite o sua idade");
					campoidade.setValidador(new ValidadorNumerico());
					campoidade.setValor(idade);

				}

				String login = JOptionPane
						.showInputDialog("Digite o seu login");
				Campo campoLogin = new Campo(Campo.LOGIN, "login", login);

				while (campoLogin.validar() == false) {
					login = JOptionPane.showInputDialog("Digite o seu login");
					campoLogin.setValor(login);

				}
				String senhaNumerica = JOptionPane
						.showInputDialog("Digite sua senha numerica");
				Campo senhaN = new Campo(Campo.SENHANUMERICA, "SENHA NUMERICA",
						senhaNumerica);

				while (senhaN.validar() == false) {
					senhaNumerica = JOptionPane
							.showInputDialog("Digite o sua senha numerica");
					senhaN.setValor(senhaNumerica);

				}

				String senhaTexto = JOptionPane
						.showInputDialog("Digite a sua senha texto");
				Campo senhaT = new Campo(Campo.SENHATEXTO, "SENHA TEXTO", senhaTexto);

				while (senhaT.validar() == false) {
					senhaTexto = JOptionPane
							.showInputDialog("Digite a sua senha texto");
					senhaT.setValor(senhaTexto);

				}
				if (campotexto.validar() && campoemail.validar()
						&& campoidade.validar() && campoLogin.validar()) {
					addCampo(campotexto);
					addCampo(campoemail);
					addCampo(campoidade);
					addCampo(campoLogin);
					addCampo(senhaT);
					addCampo(senhaN);
				}

				opcao2 = menu2();
				if (opcao2.equalsIgnoreCase("f"))
					break;
			}

			return;
		}
	}

}
