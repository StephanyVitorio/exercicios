package br.ufpb.br.aps.stephanymariana.projeto1;

import java.util.List;

public class Fachada {

	Artigo artigo = new Artigo();
	Usuario usuario = new Usuario();
	GerenteArtigo art = new GerenteArtigo();
	GerenteUsuario urs = new GerenteUsuario();
	Administrador admin = new Administrador();
	Usuario usuarioLogado = null ;
	
	public void login(String nome, String senha){
		usuarioLogado = urs.login(nome, senha);
	}

	public void aprovarCadastoUsuario(Usuario u) {
		urs.aprovarCadastoUsuario(u);
	}

	public void cadastrarUsuario(Usuario u) {
		urs.cadastrarUsuario(u);
	}

	public void cadastrarAdministrador(Administrador a) {
		urs.cadastrarAdministrador(a);
	}

	public void adicionarArtigo(Artigo artigo) {
		art.adicionarArtigo(artigo);
	}

	public void removerArtigo(Artigo artigo) {
		art.removerArtigo(artigo);
	}

	public void eliminarMaterialImproprio(Artigo artigo) {
		art.eliminarMaterialImproprio(artigo);
	}

	public List<Artigo> pesquisarPorAutor(String autor) {
		return art.pesquisarPorAutor(autor);
	}

	public List<Artigo> pesquisarArtigoPorPalavra(String palavra) {
		return art.pesquisarArtigoPorPalavra(palavra);
	}

	public List<Artigo> pesquisarArtigoPorTitulo(String titulo) {
		return art.pesquisarArtigoPorTitulo(titulo);
	}

	public List<Artigo> pesquisarMateriaisCompartilhados() {
		return null;
	}

	public void compartilharMaterial(Artigo artigo, Usuario u) {
	}

	public List<Administrador> listarAdminitradores() {

		return urs.getListAdministrador();
	}

	public List<Usuario> listarUsuario() {

		return urs.getListUsuario();
	}

	public List<Artigo> listarArtigo() {

		return art.getListarArtigo();
	}

	public List<Usuario> listarUsuarioAprovado() {
		return urs.getListUsuarioAprovado();
	}

}
