package ProjetoApsv6;

import java.util.LinkedList;
import java.util.List;

public class GerenteDeUsuarios {

	Pessoa usuarioLogado = null;

	public Pessoa getUsuarioLogado() {
		return usuarioLogado;
	}

	public void cadastrarUsuario(Usuario u) {
		if (!verificarSeLoginExiste(u.getLogin())) {
			GerenteDePersistencia.getPersistencia().usuariosPendentes.add(u);
		}else
			throw new GerenciadorDeArtigosException(
				"O login já existe");

	}

	public void cadastrarAdministrador(Administrador a) {

		GerenteDePersistencia.getPersistencia().usuarios.add(a);

	}

	public void Login(String login, String senha) {
		for (Pessoa p : GerenteDePersistencia.getPersistencia().usuarios) {
			if (p.login(login, senha)) {
				usuarioLogado = p;
				return;
			}
		}
		throw new GerenciadorDeArtigosException(
				"O usuario não consta  na lista de usuarios aprovados");

	}

	public boolean verificarSeLoginExiste(String login) {

		for (Pessoa p : GerenteDePersistencia.getPersistencia().usuariosPendentes) {
			if (p.getLogin().equals(login)) {
				return true;
			}
		}
		for (Pessoa p : GerenteDePersistencia.getPersistencia().usuarios) {
			if (p.getLogin().equals(login)) {
				return true;
			}
		}
		return false;
	}

	public void aprovarCadastoUsuario(Usuario u) {
		GerenteDePersistencia.getPersistencia().usuarios.add(u);

		GerenteDePersistencia.getPersistencia().usuariosPendentes.remove(u);

	}

	public List<Administrador> getListAdministrador() {
		List<Administrador> adm = new LinkedList<Administrador>();
		for (Pessoa p : GerenteDePersistencia.getPersistencia().usuarios) {
			if (p.temPermissaoAdministrativa()) {
				adm.add((Administrador) p);
			}
		}
		return adm;
	}

	public List<Usuario> getListUsuario() {
		return GerenteDePersistencia.getPersistencia().usuariosPendentes;
	}

	public List<Usuario> getListUsuarioAprovado() {
		List<Usuario> usu = new LinkedList<Usuario>();
		for (Pessoa p : GerenteDePersistencia.getPersistencia().usuarios) {
			if (!p.temPermissaoAdministrativa()) {
				usu.add((Usuario) p);
			}
		}
		return usu;

	}

	public List<Artigo> pesquisarPorAutor(String autor) {
		List<Artigo> artigoPorAutor = new LinkedList<Artigo>();

		for (int i = 0; i < usuarioLogado.getArtigos().size(); i++) {
			if (usuarioLogado.getArtigos().get(i).getNome().contains(autor)) {
				artigoPorAutor.add(usuarioLogado.getArtigos().get(i));
			}
		}
		return artigoPorAutor;
	}

	public List<Artigo> pesquisarArtigoPorPalavra(String palavra) {

		List<Artigo> artigoPorPalavra = new LinkedList<Artigo>();
		for (int i = 0; i < usuarioLogado.getArtigos().size(); i++) {
			if (usuarioLogado.getArtigos().get(i).getResumo().contains(palavra)) {
				artigoPorPalavra.add(usuarioLogado.getArtigos().get(i));
			}
		}
		return artigoPorPalavra;
	}

	public List<Artigo> pesquisarArtigoPorTitulo(String titulo) {
		List<Artigo> artigoPorTitulo = new LinkedList<Artigo>();
		for (int i = 0; i < usuarioLogado.getArtigos().size(); i++) {
			if (usuarioLogado.getArtigos().get(i).getTitulo().contains(titulo)) {
				artigoPorTitulo.add(usuarioLogado.getArtigos().get(i));
			}
		}
		return artigoPorTitulo;
	}
}
