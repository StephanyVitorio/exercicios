package br.ufpb.aps.stephany.exercicio2;



public class Campo {

	private Validador validador;
	private String label;
	private int id;
	private String valor;
	private String erro;
	public static final int NOME = 1;
	public static final int IDADE = 2;
	public static final int EMAIL = 3;
	public static final int LOGIN = 4;
	public static final int SENHATEXTO = 5;
	public static final int SENHANUMERICA = 6;

	public Campo(int id, String label, String valor) {
		this.label = label;
		this.id = id;
		this.erro = "";
		this.valor = valor;

		switch (id) {

		case NOME: {

			this.setValidador(new ValidadorNomeDecorator(new ValidadorTexto()));
			break;
		}

		case IDADE: {
			this.setValidador(new ValidadorIdadeDecorator(
					new ValidadorNumerico()));
			break;
		}

		case EMAIL: {
			this.setValidador(new ValidadorEmail());
			break;
		}
		case LOGIN: {
			this.setValidador(new validadorLoginDecorator(new ValidadorTexto()));
			break;

		}
		case SENHATEXTO: {
			this.setValidador(new ValidadorSenhaTextoDecorator(
					new ValidadorSenha()));
			break;
		}
		case SENHANUMERICA: {
			this.setValidador(new ValidadorSenhaNumericaDecorator(
					new ValidadorNumerico()));
			break;
		}
		}
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public Validador getValidador() {
		return validador;
	}

	public void setValidador(Validador validador) {
		this.validador = validador;
	}

	public Campo(String a) {

	}

	public void validar() throws ValorInvalidoException {

		this.validador.validar(valor);

	}

	public String getErro() {
		return this.erro;
	}

	public String toString() {
		return getLabel() + " : " + getValor();
	}

}
