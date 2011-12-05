package observer;


public class Ifax implements CTlistner{

	public Ifax() {
		
	}
public void EventoChamadaRecebida(Evento e){
		
		if(e.getSinal().getTipo().equals("sinalFax"))
			imprimir();
	}
	public void imprimir(){
		
		 System.out.print("msg");
	}

}
