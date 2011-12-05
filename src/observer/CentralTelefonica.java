package observer;

import java.util.LinkedList;
import java.util.List;


public class CentralTelefonica {
	List <CTlistner> listners;
	String nome;
	String marca;
	String n;
	
	public CentralTelefonica(String n){
		listners=new LinkedList<CTlistner>();
		this.n=n;
	}
	
	public void ChamadaRecebida(Sinal s){
		for(CTlistner c: listners){
			c.EventoChamadaRecebida(new Evento(s,this.nome,this.marca));
		}
	}

	public void addListner(CTlistner c) {
		this.listners.add(c);		
	}
}
