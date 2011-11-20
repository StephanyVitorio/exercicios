package br.ufpb.aps.stephany.exercicio4;



public class Cliente {
	private ListaEncadeada listaEnc;
	
	public Cliente(ListaEncadeada lista) {
			this.listaEnc = lista;
	}

	public void printElemento() {
		Iterator itEncadead = listaEnc.getIterator();
		System.out.println("Os Itens digitados são:\n");
		printElemento(itEncadead);
	}

	public void printElemento(Iterator it) {
		while (it.temProximo()) {
			Item e = (Item) it.proximo();
			System.out.println(e.getItem());
		}
	}

}
