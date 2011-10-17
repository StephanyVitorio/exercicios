package br.ufpb.aps.stephany.exercicio;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;



public class Formulario {

	private List<Campo> campos;

	public Formulario() {
		this.campos = new LinkedList<Campo>();
	}

	public void addCampo(Campo campo) {
		this.campos.add(campo);
	}

	public String listarItens() {
		String retorno = "";
		for (Campo c : campos) {
			retorno += "\n" + c.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, retorno);
		return retorno;
	}

	
}
