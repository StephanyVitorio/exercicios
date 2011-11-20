package br.ufpb.aps.stephany.exercicio4;

import java.util.LinkedList;

public class ListaEncadeadaConcreta implements ListaEncadeada {
	LinkedList <Object>lista = new LinkedList <Object>();

	@Override
	public void add(Object o) {
		lista.add(o);
		
	}

	@Override
	public Iterator getIterator() {
			return new IteratorConcreto(lista);
	}

}
