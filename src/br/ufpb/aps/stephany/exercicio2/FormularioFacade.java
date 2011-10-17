package br.ufpb.aps.stephany.exercicio2;

public class FormularioFacade {

	Formulario form = new Formulario();

	public void addCampo(Campo campo) {
		form.addCampo(campo);
	}

	public void listarItens() {
		form.listarItens();
	}
}
