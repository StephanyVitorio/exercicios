package ProjetoApsv7;

import java.util.List;

public class Fachada {

	GerenteArtigos gerenteArtigos = new GerenteArtigos();
	GerenteDeUsuarios gerenteUsuarios = new GerenteDeUsuarios();
	GerenteDePersistencia persistencia = new GerenteDePersistencia();

	public Fachada() {
		recuperarArquivo();
	}

	public void cadastrarAdministrador(Administrador a) {
		if (!gerenteUsuarios.getListAdministrador().contains(a)) {
			gerenteUsuarios.cadastrarAdministrador(a);
			salvarEmArquivo();
		} else {
			throw new GerenciadorDeArtigosException(
					"O Administrador ja está cadastrado ... ");
		}
	}

	public void cadastrarUsuario(Usuario u) {
		if (!gerenteUsuarios.getListUsuario().contains(u)) {
			gerenteUsuarios.cadastrarUsuario(u);
			salvarEmArquivo();
		} else {
			throw new GerenciadorDeArtigosException(
					"O Usuario ja está cadastrado ... ");
		}

	}

	public void aprovarCadastoUsuario(Usuario u) {

		if (gerenteUsuarios.getUsuarioLogado() != null
				&& gerenteUsuarios.getUsuarioLogado()
						.temPermissaoAdministrativa()) {
			gerenteUsuarios.aprovarCadastoUsuario(u);
		} else {
			throw new GerenciadorDeArtigosException(
					"O usuário Logado não é administrador");
		}
		salvarEmArquivo();
	}

	public void adicionarArtigo(Artigo artigo) {

		gerenteUsuarios.getUsuarioLogado().adicionarArtigo(artigo);
		salvarEmArquivo();
	}

	public void removerArtigo(Artigo artigo) {
		gerenteUsuarios.getUsuarioLogado().removerArtigo(artigo);
		salvarEmArquivo();
	}

	public List<Artigo> pesquisarPorAutor(String autor) {
		if (autor == null) {
			throw new GerenciadorDeArtigosException("Escreva o nome do autor");
		}

		return gerenteUsuarios.pesquisarPorAutor(autor);

	}

	public List<Artigo> pesquisarArtigoPorTitulo(String titulo) {
		if (titulo == null) {
			throw new GerenciadorDeArtigosException("Escreva o nome do titulo");
		}
		return gerenteUsuarios.pesquisarArtigoPorTitulo(titulo);
	}

	public List<Artigo> pesquisarArtigoPorPalavra(String palavra) {
		if (palavra == null) {
			throw new GerenciadorDeArtigosException("Escreva o nome da palavra");
		}
		return gerenteUsuarios.pesquisarArtigoPorPalavra(palavra);
	}

	public void compartilharMaterial(Artigo artigo) {
		gerenteArtigos.compartilharMaterial(artigo);
		salvarEmArquivo();
	}

	public void removerArtigoCompartilhado(Artigo artigo) {

		gerenteArtigos.removerMaterial(artigo);

		salvarEmArquivo();
	}

	public List<Artigo> pesquisarMateriaisCompartilhados() {
		return gerenteArtigos.getTodosArtigosCompartilhados();

	}

	public void eliminarMaterialImproprio(Artigo artigo) {
		if (gerenteUsuarios.getUsuarioLogado().temPermissaoAdministrativa()) {
			gerenteArtigos.eliminarMaterialImproprioCompartilhado(artigo);
		} else {
			throw new GerenciadorDeArtigosException(
					"O usuário Logado não é administrador");
		}
		salvarEmArquivo();

	}

	public void login(String login, String senha) {

		gerenteUsuarios.Login(login, senha);

	}

	public void salvarEmArquivo() {
		persistencia.persistir();
	}

	public void recuperarArquivo() {
		persistencia.recuperar();
	}

	public List<Administrador> listarAdminitradores() {

		return gerenteUsuarios.getListAdministrador();
	}

	public List<Usuario> listarUsuario() {

		return gerenteUsuarios.getListUsuario();
	}

	public List<Artigo> listarArtigo() {

		return gerenteUsuarios.getUsuarioLogado().getArtigos();
	}

	public List<Usuario> listarUsuarioAprovado() {
		if (gerenteUsuarios.getListUsuarioAprovado().size() == 0) {
			throw new GerenciadorDeArtigosException(
					"Não existe usuário Aprovado");
		}
		return gerenteUsuarios.getListUsuarioAprovado();

	}

	public List<Artigo> pesquisarMateriaisCompartilhadosPorAutor(String nome) {
		return gerenteArtigos.pesquisarArtigosCompartilhadosPorAutor(nome);

	}

	public List<Artigo> pesquisarMateriaisCompartilhadosPorTitulo(String titulo) {
		return gerenteArtigos.pesquisarArtigosCompartilhadosPorTitulo(titulo);
	}

	public List<Artigo> pesquisarMateriaisCompartilhadosPorPalavra(
			String palavra) {

		return gerenteArtigos.pesquisarArtigosCompartilhadosPorPalavra(palavra);
	}

	public List<Artigo> listarArtigosCompartilhados() {
		return gerenteArtigos.getTodosArtigosCompartilhados();
	}

}
