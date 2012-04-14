package br.ufpb.br.aps.stephanymariana.projeto1;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class Teste {
	@Test
	public void cadastrarAdministrador() {
		Fachada fachada = new Fachada();

		Administrador a = new Administrador();
		a.setNome("Ste");
		a.setId("12345");
		a.setEnd("Rua1");
		fachada.cadastrarAdministrador(a);
		List<Administrador> admin = fachada.listarAdminitradores();
		Administrador aCadastrado = admin.get(0);
		Assert.assertEquals(a.getEnd(), aCadastrado.getEnd());
		Assert.assertEquals(a.getId(), aCadastrado.getId());
		Assert.assertEquals(a.getNome(), aCadastrado.getNome());
	}

	@Test
	public void cadastrarUsuario() {
		Fachada fachada = new Fachada();

		Usuario u = new Usuario();
		u.setNome("usuario1");
		u.setEnd("Rua1");
		u.setInstituicao("ufpb");
		fachada.cadastrarUsuario(u);
		List<Usuario> usuarios = fachada.listarUsuario();
		Usuario aCadastrado = usuarios.get(0);
		Assert.assertEquals(u.getEnd(), aCadastrado.getEnd());
		Assert.assertEquals(u.getInstituicao(), aCadastrado.getInstituicao());
		Assert.assertEquals(u.getNome(), aCadastrado.getNome());
	}

	@Test
	public void aprovarCadastroUsuario() {
		Fachada fachada = new Fachada();

		Usuario u = new Usuario();
		u.setNome("usuario1");
		u.setEnd("Rua1");
		u.setInstituicao("ufpb");
		fachada.cadastrarUsuario(u);
		List<Usuario> usuarios = fachada.listarUsuario();
		Usuario aCadastrado = usuarios.get(0);
		Assert.assertEquals(u.getEnd(), aCadastrado.getEnd());
		Assert.assertEquals(u.getInstituicao(), aCadastrado.getInstituicao());
		Assert.assertEquals(u.getNome(), aCadastrado.getNome());
		fachada.aprovarCadastoUsuario(u);
		List<Usuario> usuariosAprovados = fachada.listarUsuarioAprovado();
		int size = usuariosAprovados.size();
		int size1 = usuarios.size();
		Assert.assertEquals(1, size);
		Assert.assertEquals(0, size1);
	}

	@Test
	public void inserirArtigo() {
		Fachada fachada = new Fachada();

		Artigo a = new Artigo();
		a.setNome("Nome");
		a.setCaminho("url");
		a.setTitulo("titulo");
		a.setResumo("resumo");
		fachada.adicionarArtigo(a);
		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		Assert.assertEquals(a.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(a.getNome(), aCadastrado.getNome());
		Assert.assertEquals(a.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(a.getResumo(), aCadastrado.getResumo());
		int size = artigos.size();
		Assert.assertEquals(1, size);
	}

	@Test
	public void removerArtigo() {
		Fachada fachada = new Fachada();

		Artigo a = new Artigo();
		a.setNome("Nome");
		a.setCaminho("url");
		a.setTitulo("titulo");
		a.setResumo("resumo");
		fachada.adicionarArtigo(a);
		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		Assert.assertEquals(a.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(a.getNome(), aCadastrado.getNome());
		Assert.assertEquals(a.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(a.getResumo(), aCadastrado.getResumo());
		fachada.removerArtigo(a);
		int size = artigos.size();
		Assert.assertEquals(0, size);
	}

	@Test
	public void pesquisarArtigoAutor() {
		Fachada fachada = new Fachada();

		Artigo a = new Artigo();
		a.setNome("Nome");
		a.setCaminho("url");
		a.setTitulo("titulo");
		a.setResumo("resumo");
		fachada.adicionarArtigo(a);

		Artigo e = new Artigo();
		e.setNome("ABC");
		e.setCaminho("caminho");
		e.setTitulo("Aps");
		e.setResumo("casa");
		fachada.adicionarArtigo(e);

		List<Artigo> artigos = fachada.listarArtigo();

		Artigo aCadastrado = artigos.get(0);
		Assert.assertEquals(a.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(a.getNome(), aCadastrado.getNome());
		Assert.assertEquals(a.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(a.getResumo(), aCadastrado.getResumo());

		Artigo eCadastrado = artigos.get(1);
		Assert.assertEquals(e.getCaminho(), eCadastrado.getCaminho());
		Assert.assertEquals(e.getNome(), eCadastrado.getNome());
		Assert.assertEquals(e.getTitulo(), eCadastrado.getTitulo());
		Assert.assertEquals(e.getResumo(), eCadastrado.getResumo());

		String nome = "Nome";

		List<Artigo> autores = fachada.pesquisarPorAutor(nome);
		aCadastrado = autores.get(0);
		Assert.assertEquals(a.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(a.getNome(), aCadastrado.getNome());
		Assert.assertEquals(a.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(a.getResumo(), aCadastrado.getResumo());

		Assert.assertEquals(1, autores.size());
	}

	@Test
	public void pesquisarArtigoTitulo() {
		Fachada fachada = new Fachada();

		Artigo a = new Artigo();
		a.setNome("Nome");
		a.setCaminho("url");
		a.setTitulo("titulo");
		a.setResumo("resumo");
		fachada.adicionarArtigo(a);

		Artigo e = new Artigo();
		e.setNome("ABC");
		e.setCaminho("caminho");
		e.setTitulo("Aps");
		e.setResumo("casa");
		fachada.adicionarArtigo(e);

		List<Artigo> artigos = fachada.listarArtigo();

		Artigo aCadastrado = artigos.get(0);
		Assert.assertEquals(a.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(a.getNome(), aCadastrado.getNome());
		Assert.assertEquals(a.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(a.getResumo(), aCadastrado.getResumo());

		Artigo eCadastrado = artigos.get(1);
		Assert.assertEquals(e.getCaminho(), eCadastrado.getCaminho());
		Assert.assertEquals(e.getNome(), eCadastrado.getNome());
		Assert.assertEquals(e.getTitulo(), eCadastrado.getTitulo());
		Assert.assertEquals(e.getResumo(), eCadastrado.getResumo());

		String titulo = "titulo";

		List<Artigo> titulos = fachada.pesquisarArtigoPorTitulo(titulo);
		aCadastrado = titulos.get(0);
		Assert.assertEquals(a.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(a.getNome(), aCadastrado.getNome());
		Assert.assertEquals(a.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(a.getResumo(), aCadastrado.getResumo());

		Assert.assertEquals(1, titulos.size());
	}

	@Test
	public void pesquisarArtigoPorPalavra() {
		Fachada fachada = new Fachada();

		String palavra = "resumo";
		Artigo a = new Artigo();
		a.setNome("Nome");
		a.setCaminho("url");
		a.setTitulo("titulo");
		a.setResumo("resumo");
		fachada.adicionarArtigo(a);

		Artigo e = new Artigo();
		e.setNome("ABC");
		e.setCaminho("caminho");
		e.setTitulo("Aps");
		e.setResumo("casa");
		fachada.adicionarArtigo(e);

		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		Assert.assertEquals(a.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(a.getNome(), aCadastrado.getNome());
		Assert.assertEquals(a.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(a.getResumo(), aCadastrado.getResumo());

		Artigo eCadastrado = artigos.get(1);
		Assert.assertEquals(e.getCaminho(), eCadastrado.getCaminho());
		Assert.assertEquals(e.getNome(), eCadastrado.getNome());
		Assert.assertEquals(e.getTitulo(), eCadastrado.getTitulo());
		Assert.assertEquals(e.getResumo(), eCadastrado.getResumo());

		fachada.pesquisarArtigoPorPalavra(palavra);

		List<Artigo> palavras = fachada.pesquisarArtigoPorPalavra(palavra);
		aCadastrado = palavras.get(0);
		Assert.assertEquals(a.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(a.getNome(), aCadastrado.getNome());
		Assert.assertEquals(a.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(a.getResumo(), aCadastrado.getResumo());

		Assert.assertEquals(1, palavras.size());
	}

	@Test
	public void eliminarMaterialImproprio() {
		Fachada fachada = new Fachada();

		Artigo a = new Artigo();
		a.setNome("Nome");
		a.setCaminho("url");
		a.setTitulo("Titulo");
		a.setResumo("RR");
		fachada.adicionarArtigo(a);

		Artigo e = new Artigo();
		e.setNome("ABC");
		e.setCaminho("caminho");
		e.setTitulo("Aps");
		e.setResumo("Resumo");
		fachada.adicionarArtigo(e);

		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		Assert.assertEquals(a.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(a.getNome(), aCadastrado.getNome());
		Assert.assertEquals(a.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(a.getResumo(), aCadastrado.getResumo());

		Artigo eCadastrado = artigos.get(1);
		Assert.assertEquals(e.getCaminho(), eCadastrado.getCaminho());
		Assert.assertEquals(e.getNome(), eCadastrado.getNome());
		Assert.assertEquals(e.getTitulo(), eCadastrado.getTitulo());
		Assert.assertEquals(e.getResumo(), eCadastrado.getResumo());

		fachada.eliminarMaterialImproprio(a);

		int size = artigos.size();
		Assert.assertEquals(1, size);
	}

	@Test
	public void compartilharMaterial() {

	}

	/*
	 * @Test public void pesquisarrMateriaisCompartilhados() {
	 * 
	 * }
	 */

}
