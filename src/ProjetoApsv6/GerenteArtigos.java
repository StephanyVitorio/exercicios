package ProjetoApsv6;

import java.util.LinkedList;
import java.util.List;

public class GerenteArtigos {

	public void compartilharMaterial(Artigo art) {
		GerenteDePersistencia.getPersistencia().artigos.add(art);

	}

	public void eliminarMaterialImproprioCompartilhado(Artigo art) {
		GerenteDePersistencia.getPersistencia().artigos.remove(art);
	}

	public List<Artigo> getTodosArtigosCompartilhados() {
		return GerenteDePersistencia.getPersistencia().artigos;
	}
	public void removerMaterial(Artigo art) {
		GerenteDePersistencia.getPersistencia().artigos.remove(art);
	}

	public List<Artigo> pesquisarArtigosCompartilhadosPorAutor(String autor) {
		List<Artigo> artigoPorAutor = new LinkedList<Artigo>();
		for (int i = 0; i < GerenteDePersistencia.getPersistencia().artigos
				.size(); i++) {
			if (GerenteDePersistencia.getPersistencia().artigos.get(i)
					.getNome().contains(autor)) {
				artigoPorAutor
						.add(GerenteDePersistencia.getPersistencia().artigos
								.get(i));
			}
		}
		return artigoPorAutor;
	}

	public List<Artigo> pesquisarArtigosCompartilhadosPorPalavra(String palavra) {
		List<Artigo> artigoPorPalavra = new LinkedList<Artigo>();
		for (int i = 0; i < GerenteDePersistencia.getPersistencia().artigos
				.size(); i++) {
			if (GerenteDePersistencia.getPersistencia().artigos.get(i)
					.getResumo().contains(palavra)) {
				artigoPorPalavra
						.add(GerenteDePersistencia.getPersistencia().artigos
								.get(i));
			}
		}
		return artigoPorPalavra;
	}

	public List<Artigo> pesquisarArtigosCompartilhadosPorTitulo(String titulo) {
		List<Artigo> artigoPorTitulo = new LinkedList<Artigo>();
		for (int i = 0; i < GerenteDePersistencia.getPersistencia().artigos
				.size(); i++) {
			if (GerenteDePersistencia.getPersistencia().artigos.get(i)
					.getTitulo().contains(titulo)) {
				artigoPorTitulo
						.add(GerenteDePersistencia.getPersistencia().artigos
								.get(i));
			}
		}
		return artigoPorTitulo;
	}

	

}
