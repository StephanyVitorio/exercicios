package br.ufpb.br.aps.stephanymariana.projeto;

import java.util.List;

public class Fachada {

	// Aprova cadastro de usuário

	public void aprovarCadastoUsuario(Usuario u) {
	}

	// submete cadastro de usuário para aprovação
	public void cadastrarUsuario(Usuario u) {
	}

	// Cadastra administrador
	public void cadastrarAdministrador(Administrador a) {
	}

	// ver com professor
	public void eliminarMaterialImproprio(Artigo artigo) {
	}

	// Adiciona artigo mas não deixa publico
	public void adicionarArtigo(Artigo artigo) {
	}

	// remove artigo
	public void removerArtigo(Artigo artigo) {
	}

	// faz pesquisa a partir do nome do autor
	public Artigo pesquisarPorAutor(String autor) {
		return null;
	}

	// pesuqisa artigo por palvras
	public Artigo pesquisarArtigoPorPalavra(String palavra) {
		return null;
	}

	// pesquisa artigo por titulo
	public Artigo pesquisarArtigoPorTitulo(String titulo) {
		return null;
	}

	// retorna uma lista com todos artigos compartilhados

	public List pesquisarMateriaisCompartilhados() {
		return null;
	}

	// compartilha arquivo
	public void compartilharMaterial(Artigo artigo) {
	}

}
