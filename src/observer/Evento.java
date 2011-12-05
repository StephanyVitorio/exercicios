package observer;


public class Evento {

	Sinal s;
	String NomeCentral;
	String MarcaCentral;
	
	
	public Evento(Sinal s, String nomeCentral, String marcaCentral) {
		
		this.s = s;
		NomeCentral = nomeCentral;
		MarcaCentral = marcaCentral;
	}
	public Sinal getSinal(){
		return s;
	}
	

}
