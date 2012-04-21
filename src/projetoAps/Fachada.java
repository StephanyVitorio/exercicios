package projetoAps;

import java.util.List;

public class Fachada {

	Artigo artigo = new Artigo();
	Usuario usuario = new Usuario();
	GerenteArtigosCompartilhados art = new GerenteArtigosCompartilhados();
	Gerenciador urs = new Gerenciador();
	Administrador admin = new Administrador();
	Pessoa usuarioLogado = null;

	public void cadastrarAdministrador(Administrador a) {
		urs.cadastrarAdministrador(a);
	}

	public void cadastrarUsuario(Usuario u) {
		urs.cadastrarUsuario(u);
	}

	public void aprovarCadastoUsuario(Usuario u) {
		if (usuarioLogado instanceof Administrador) {
			urs.aprovarCadastoUsuario(u);
		} else {
			throw new GerenciadorDeArtigosException(
					"O usuário Logado não é administrador");
		}

	}

	public void adicionarArtigo(Artigo artigo) {
		usuarioLogado.adicionarArtigo(artigo);
	}

	public void removerArtigo(Artigo artigo) {
		usuarioLogado.removerArtigo(artigo);
	}

	public List<Artigo> pesquisarPorAutor(String autor) {
		return usuarioLogado.pesquisarPorAutor(autor);
	}

	public List<Artigo> pesquisarArtigoPorTitulo(String titulo) {
		return usuarioLogado.pesquisarArtigoPorTitulo(titulo);
	}

	public List<Artigo> pesquisarArtigoPorPalavra(String palavra) {
		return usuarioLogado.pesquisarArtigoPorPalavra(palavra);
	}

	public void compartilharMaterial(Artigo artigo) {
		art.compartilharMaterial(artigo);
	}

	public List<Artigo> pesquisarMateriaisCompartilhados() {
		return art.getTodosArtigosCompartilhados();
	}

	public void eliminarMaterialImproprio(Artigo artigo) {
		if (usuarioLogado instanceof Administrador) {
			art.eliminarMaterialImproprioCompartilhado(artigo);
		} else {
			throw new GerenciadorDeArtigosException(
					"O usuário Logado não é administrador");
		}

	}	
	public void login(String login, String senha) {
		usuarioLogado = urs.Login(login, senha);

	}

	public List<Administrador> listarAdminitradores() {

		return urs.getListAdministrador();
	}

	public List<Usuario> listarUsuario() {

		return urs.getListUsuario();
	}

	public List<Artigo> listarArtigo() {

		return usuarioLogado.getListarArtigo();
	}

	public List<Usuario> listarUsuarioAprovado() {
		return urs.getListUsuarioAprovado();
	}

}
