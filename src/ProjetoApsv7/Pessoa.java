package ProjetoApsv7;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public abstract class Pessoa implements Serializable {

	String nome;
	String end;
	String login;
	String senha;
	protected List<Artigo> artigos = new LinkedList<Artigo>();

	public boolean login(String login, String senha) {
		return (this.login.equals(login)) && (this.senha.equals(senha));
	}

	public boolean temPermissaoAdministrativa() {
		return false;
	}

	public String getNome() {
		
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void adicionarArtigo(Artigo art) {
		if (!artigos.contains(art)) {
			artigos.add(art);
		} else {
			throw new GerenciadorDeArtigosException(
					"O Artigo ja está cadastrado ... ");
		}
	}

	public void removerArtigo(Artigo art) {

		if (artigos.size() != 0) {
			artigos.remove(art);
		} else {
			throw new GerenciadorDeArtigosException(
					"Não existe artigo cadastrado... ");
		}

	}

	public List<Artigo> getArtigos() {
		return artigos;
	}

	public abstract boolean metodoCompare(Pessoa u );
}
