package ProjetoApsv6;

import java.io.Serializable;

public class Artigo implements Serializable{
		
	String nome;
	String titulo;
	String resumo;
	String caminho;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public boolean metodoCompare(Artigo a ){
		{
			 if (this.titulo.equals(a.getTitulo()) && this.nome.equals(a.getNome()) 
					 && this.resumo.equals(a.getResumo()) && this.caminho.equals(a.getCaminho())
					 ){
				    return true;
				}
				return false;
		
		}
	}
}
