package br.ufpb.br.aps.stephanymariana.projeto1;

import java.util.LinkedList;
import java.util.List;

public class GerenteArtigo {

	List<Artigo> artigo = new LinkedList<Artigo>();

	public void adicionarArtigo(Artigo art) {
		artigo.add(art);
	}

	public void removerArtigo(Artigo art) {
		artigo.remove(art);
	}

	public void eliminarMaterialImproprio(Artigo art) {
		String palavra = " RR ";

		List<Artigo> artigosRemover = new LinkedList<Artigo>();
		for (int i = 0; i < artigo.size(); i++) {
			if ((artigo.get(i).getResumo().contains(palavra) || artigo.get(i)
					.getResumo().equals("RR"))
					|| (artigo.get(i).getTitulo().contains(palavra) || artigo
							.get(i).getTitulo().equals("RR"))
					|| (artigo.get(i).getNome().contains(palavra) || artigo
							.get(i).getNome().equals("RR"))) {
				artigosRemover.add(artigo.get(i));

			}
		}

		for (Artigo muv : artigosRemover) {
			artigo.remove(muv);
		}

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
	
	public void compartilharMaterial(Artigo art, Usuario u) {

	}
	public List<Artigo> pesquisarMateriaisCompartilhados() {
		return null;
	}

	public List<Artigo> getListarArtigo() {
		return artigo;
	}

}
