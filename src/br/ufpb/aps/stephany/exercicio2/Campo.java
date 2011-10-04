package br.ufpb.aps.stephany.exercicio2;

import javax.swing.JOptionPane;

public class Campo {
	
	private Validador validador;
	private String label;
	private int id;
	private String valor;
	private String erro;
	public static final int NOME= 1;
	public static final int IDADE=2;
	public static final int EMAIL=3;
	
	
	
	public Campo(int id,String label,String valor){
		this.label = label;
		this.id = id;
		this.erro = "";
		this.valor=valor;
		
		switch (id){
		
		case NOME:{
			this.setValidador(new ValidadorTexto());
			break;
		}
		
		case IDADE:{
			this.setValidador(new ValidadorNumerico());
			
		}
		
		case EMAIL:{
			this.setValidador(new ValidadorEmail());
			
		}
				
		
		}
	}
	
	
	
	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}



	public void setErro(String erro) {
		this.erro = erro;
	}



	public Validador getValidador() {
		return validador;
	}



	public void setValidador(Validador validador) {
		this.validador = validador;
	}



	public Campo(String a) {
		
	}



	public boolean validar(){
		try{
			this.validador.validar(valor);	
			return true;
		}catch(ValorInvalidoException e){
			this.erro = e.getMessage();
			JOptionPane.showMessageDialog(null,e.getMessage());
			return false;
		}
	}
	
	public String getErro(){
		return this.erro;
	}
	
	public String toString(){	
		return getLabel()+" : "+ getValor();
	}

}
