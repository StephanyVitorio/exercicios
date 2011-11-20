package br.ufpb.aps.stephany.exercicio4;

public class ClienteTeste {
	public static void main(String args[]) {
		ListaEncadeada lista = new ListaEncadeadaConcreta();
		
		lista.add(new Item (1));
		lista.add(new Item ("ste"));
		lista.add(new Item ("1"));
		
		
		Cliente cli = new Cliente (lista);
		
		cli.printElemento();
		
	}
}
