package observer;


public class modem implements CTlistner{

	public modem() {
		
	}
	public void EventoChamadaRecebida(Evento e){
			
			if(e.getSinal().getTipo().equals("sinalModem"))
				conectar();
		}
		public void conectar(){
			
			 System.out.print("Conectado");
		}
	

	
	}

