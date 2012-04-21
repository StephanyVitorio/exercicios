package projetoAps;

import java.util.LinkedList;
import java.util.List;

public class Pessoa {

	String nome;
	String end;
	String login;
	String senha;
	protected List<Artigo> artigo = new LinkedList<Artigo>();

	public boolean login(String login, String senha) {
		return (this.login.equals(login)) && (this.senha.equals(senha));
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
		artigo.add(art);
	}

	public void removerArtigo(Artigo art) {
		artigo.remove(art);
	}

	public List<Artigo> pesquisarPorAutor(String autor) {
		List<Artigo> artigoPorAutor = new LinkedList<Artigo>();
		for (int i = 0; i < artigo.size(); i++) {
			if (artigo.get(i).getNome().contains(autor)) {
				artigoPorAutor.add(artigo.get(i));
			}
		}
		return artigoPorAutor;
	}

	public List<Artigo> pesquisarArtigoPorPalavra(String palavra) {
		List<Artigo> artigoPorPalavra = new LinkedList<Artigo>();
		for (int i = 0; i < artigo.size(); i++) {
			if (artigo.get(i).getResumo().contains(palavra)) {
				artigoPorPalavra.add(artigo.get(i));
			}
		}
		return artigoPorPalavra;
	}

	public List<Artigo> pesquisarArtigoPorTitulo(String titulo) {
		List<Artigo> artigoPorTitulo = new LinkedList<Artigo>();
		for (int i = 0; i < artigo.size(); i++) {
			if (artigo.get(i).getTitulo().contains(titulo)) {
				artigoPorTitulo.add(artigo.get(i));
			}
		}
		return artigoPorTitulo;
	}

	public List<Artigo> getListarArtigo() {
		return artigo;
	}

}
