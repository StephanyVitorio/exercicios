package Projeto;

import java.util.LinkedList;
import java.util.List;

public class GerenteArtigosCompartilhados {

	List<Artigo> artigo = new LinkedList<Artigo>();


	public void compartilharMaterial(Artigo art) {
		artigo.add(art);

	}
	public void eliminarMaterialImproprioCompartilhado(Artigo art) {
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
	
	public List<Artigo> getTodosArtigosCompartilhados(){
		return artigo;
	}

}
