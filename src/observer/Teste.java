package observer;


public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CentralTelefonica c = new CentralTelefonica ("323423");
		PCCT c2 = new PCCT ("223344");
		 modem m = new modem();
		 Ifone f = new Ifone();
		 Ifax fx = new Ifax();
		 
		 c.addListner(m);
		 c.addListner(f);
		 c.addListner(fx);
		 
		 c2.addListner(f);
		 c2.addListner(m);
		 
		// c.ChamadaRecebida(new Sinalvoz);
		 

	}

}
