package br.ufpb.aps.stephany.exercicio;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Formulario {
		
		private List<Campo> campos;
		private String nome;
		private Map<String,Campo> mapcampo;
		
		public Formulario(){
			this("");
		}
		
		public Formulario(String nome){
			this.nome = nome;
			this.campos = new LinkedList<Campo>();
			this.mapcampo = new HashMap<String,Campo>();
		}
		
		public void addCampo(Campo campo){
			this.campos.add(campo);
		}

	}

