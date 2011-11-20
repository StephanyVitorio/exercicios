package br.ufpb.aps.stephany.exercicio4;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class IteratorConcreto implements Iterator{
	LinkedList lista ;
	int posicao = 0;
	public IteratorConcreto(LinkedList lista2) {
		this.lista = new LinkedList();
		this.lista.addAll(lista2);
	}

	@Override
	public boolean temProximo() {
			return posicao < lista.size();
	}

	@Override
	public Object proximo() {
		posicao++;
		try {
		return lista.get(posicao-1);
		
		}catch(NoSuchElementException e){
			return null;
		}
	}
		
}
