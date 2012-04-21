package Projeto;

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
		a.setLogin("adm");
		a.setSenha("senha");
		fachada.cadastrarAdministrador(a);
		
		List<Administrador> admin = fachada.listarAdminitradores();
		Administrador aCadastrado = admin.get(0);
		Assert.assertEquals(a.getEnd(), aCadastrado.getEnd());
		Assert.assertEquals(a.getId(), aCadastrado.getId());
		Assert.assertEquals(a.getNome(), aCadastrado.getNome());
		Assert.assertEquals(a.getLogin(), aCadastrado.getLogin());
		Assert.assertEquals(a.getSenha(), aCadastrado.getSenha());
	}

	@Test
	public void cadastrarUsuario() {
		Fachada fachada = new Fachada();

		Usuario u = new Usuario();
		u.setNome("usuario1");
		u.setEnd("Rua1");
		u.setInstituicao("ufpb");
		u.setLogin("adm");
		u.setSenha("senha");
		fachada.cadastrarUsuario(u);
		
		List<Usuario> usuarios = fachada.listarUsuario();
		Usuario aCadastrado = usuarios.get(0);
		Assert.assertEquals(u.getEnd(), aCadastrado.getEnd());
		Assert.assertEquals(u.getInstituicao(), aCadastrado.getInstituicao());
		Assert.assertEquals(u.getNome(), aCadastrado.getNome());
		Assert.assertEquals(u.getLogin(), aCadastrado.getLogin());
		Assert.assertEquals(u.getSenha(), aCadastrado.getSenha());
	}

	@Test
	public void aprovarCadastroUsuario() {
		Fachada fachada = new Fachada();

		Administrador a = new Administrador();
		a.setNome("Ste");
		a.setId("12345");
		a.setEnd("Rua1");
		a.setLogin("adm");
		a.setSenha("senha");
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

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

	@Test(expected = GerenciadorDeArtigosException.class)
	public void aprovarCadastroUsuarioSemLogin() {
		Fachada fachada = new Fachada();

		Administrador a = new Administrador();
		a.setNome("Ste");
		a.setId("12345");
		a.setEnd("Rua1");
		a.setLogin("adm");
		a.setSenha("senha");
		fachada.cadastrarAdministrador(a);

		Usuario u = new Usuario();
		u.setNome("usuario1");
		u.setEnd("Rua1");
		u.setInstituicao("ufpb");
		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
	}

	@Test
	public void inserirArtigo() {
		Fachada fachada = new Fachada();

		Administrador a = new Administrador();
		a.setNome("Ste");
		a.setId("12345");
		a.setEnd("Rua1");
		a.setLogin("adm");
		a.setSenha("senha");
		fachada.cadastrarAdministrador(a);

		Usuario u = new Usuario();
		u.setNome("usuario1");
		u.setEnd("Rua1");
		u.setInstituicao("ufpb");
		u.setLogin("adm");
		u.setSenha("senha");

		fachada.login(a.getLogin(), a.getSenha());
		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.getLogin(), u.getSenha());

		Artigo ar = new Artigo();
		ar.setNome("Nome");
		ar.setCaminho("url");
		ar.setTitulo("titulo");
		ar.setResumo("resumo");
		fachada.adicionarArtigo(ar);
		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		Assert.assertEquals(ar.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(ar.getNome(), aCadastrado.getNome());
		Assert.assertEquals(ar.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(ar.getResumo(), aCadastrado.getResumo());
		int size = artigos.size();
		Assert.assertEquals(1, size);
	}

	@Test
	public void removerArtigo() {
		Fachada fachada = new Fachada();

		Administrador a = new Administrador();
		a.setNome("Ste");
		a.setId("12345");
		a.setEnd("Rua1");
		a.setLogin("adm");
		a.setSenha("senha");
		fachada.cadastrarAdministrador(a);

		Usuario u = new Usuario();
		u.setNome("usuario1");
		u.setEnd("Rua1");
		u.setInstituicao("ufpb");
		u.setLogin("adm");
		u.setSenha("senha");

		fachada.login(a.getLogin(), a.getSenha());
		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.getLogin(), u.getSenha());

		Artigo ar = new Artigo();
		ar.setNome("Nome");
		ar.setCaminho("url");
		ar.setTitulo("titulo");
		ar.setResumo("resumo");
		fachada.adicionarArtigo(ar);
		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		Assert.assertEquals(ar.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(ar.getNome(), aCadastrado.getNome());
		Assert.assertEquals(ar.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(ar.getResumo(), aCadastrado.getResumo());
		fachada.removerArtigo(ar);
		int size = artigos.size();
		Assert.assertEquals(0, size);
	}

	@Test
	public void pesquisarArtigoAutor() {
		Fachada fachada = new Fachada();

		Administrador a = new Administrador();
		a.setNome("Ste");
		a.setId("12345");
		a.setEnd("Rua1");
		a.setLogin("adm");
		a.setSenha("senha");
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = new Artigo();
		ar.setNome("Nome");
		ar.setCaminho("url");
		ar.setTitulo("titulo");
		ar.setResumo("resumo");
		fachada.adicionarArtigo(ar);

		Artigo e = new Artigo();
		e.setNome("ABC");
		e.setCaminho("caminho");
		e.setTitulo("Aps");
		e.setResumo("casa");
		fachada.adicionarArtigo(e);

		List<Artigo> artigos = fachada.listarArtigo();

		Artigo aCadastrado = artigos.get(0);
		String nome = "Nome";

		List<Artigo> autores = fachada.pesquisarPorAutor(nome);
		aCadastrado = autores.get(0);
		Assert.assertEquals(ar.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(ar.getNome(), aCadastrado.getNome());
		Assert.assertEquals(ar.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(ar.getResumo(), aCadastrado.getResumo());
		Assert.assertEquals(1, autores.size());
	}

	@Test
	public void pesquisarArtigoTitulo() {
		Fachada fachada = new Fachada();

		Administrador a = new Administrador();
		a.setNome("Ste");
		a.setId("12345");
		a.setEnd("Rua1");
		a.setLogin("adm");
		a.setSenha("senha");
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = new Artigo();
		ar.setNome("Nome");
		ar.setCaminho("url");
		ar.setTitulo("titulo");
		ar.setResumo("resumo");
		fachada.adicionarArtigo(ar);

		Artigo e = new Artigo();
		e.setNome("ABC");
		e.setCaminho("caminho");
		e.setTitulo("Aps");
		e.setResumo("casa");
		fachada.adicionarArtigo(e);

		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		String titulo = "titulo";
		
		List<Artigo> titulos = fachada.pesquisarArtigoPorTitulo(titulo);
		aCadastrado = titulos.get(0);
		Assert.assertEquals(ar.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(ar.getNome(), aCadastrado.getNome());
		Assert.assertEquals(ar.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(ar.getResumo(), aCadastrado.getResumo());
		Assert.assertEquals(1, titulos.size());
	}

	@Test
	public void pesquisarArtigoPorPalavra() {
		Fachada fachada = new Fachada();

		String palavra = "resumo";
		Administrador a = new Administrador();
		a.setNome("Ste");
		a.setId("12345");
		a.setEnd("Rua1");
		a.setLogin("adm");
		a.setSenha("senha");
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = new Artigo();
		ar.setNome("Nome");
		ar.setCaminho("url");
		ar.setTitulo("titulo");
		ar.setResumo("resumo");
		fachada.adicionarArtigo(ar);

		Artigo e = new Artigo();
		e.setNome("ABC");
		e.setCaminho("caminho");
		e.setTitulo("Aps");
		e.setResumo("casa");
		fachada.adicionarArtigo(e);

		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		fachada.pesquisarArtigoPorPalavra(palavra);

		List<Artigo> palavras = fachada.pesquisarArtigoPorPalavra(palavra);
		aCadastrado = palavras.get(0);
		Assert.assertEquals(ar.getCaminho(), aCadastrado.getCaminho());
		Assert.assertEquals(ar.getNome(), aCadastrado.getNome());
		Assert.assertEquals(ar.getTitulo(), aCadastrado.getTitulo());
		Assert.assertEquals(ar.getResumo(), aCadastrado.getResumo());
		Assert.assertEquals(1, palavras.size());
	}

	@Test
	public void compartilharMaterial() {
		Fachada fachada = new Fachada();

		Administrador a = new Administrador();
		a.setNome("Ste");
		a.setId("12345");
		a.setEnd("Rua1");
		a.setLogin("adm");
		a.setSenha("senha");
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = new Artigo();
		ar.setNome("Nome");
		ar.setCaminho("url");
		ar.setTitulo("titulo");
		ar.setResumo("resumo");
		fachada.adicionarArtigo(ar);
		
		List<Artigo> artigos = fachada.listarArtigo();
		fachada.compartilharMaterial(ar);
		int size = artigos.size();
		Assert.assertEquals(1, size);
	}
	@Test
	public void	pesquisarMateriaisCompartilhados(){
		Fachada fachada = new Fachada();

		Administrador a = new Administrador();
		a.setNome("Ste");
		a.setId("12345");
		a.setEnd("Rua1");
		a.setLogin("adm");
		a.setSenha("senha");
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = new Artigo();
		ar.setNome("Nome");
		ar.setCaminho("url");
		ar.setTitulo("titulo");
		ar.setResumo("resumo");
		fachada.adicionarArtigo(ar);
		
		fachada.compartilharMaterial(ar);
		Assert.assertEquals(1, fachada.pesquisarMateriaisCompartilhados()
				.size());	
	}
	
	@Test
	public void eliminarMaterialImproprio() {
		Fachada fachada = new Fachada();

		Administrador a = new Administrador();
		a.setNome("Ste");
		a.setId("12345");
		a.setEnd("Rua1");
		a.setLogin("adm");
		a.setSenha("senha");
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = new Artigo();
		ar.setNome("Nome");
		ar.setCaminho("url");
		ar.setTitulo("Titulo");
		ar.setResumo("RR");
		fachada.adicionarArtigo(ar);

		Artigo e = new Artigo();
		e.setNome("ABC");
		e.setCaminho("caminho");
		e.setTitulo("Aps");
		e.setResumo("Resumo");
		fachada.adicionarArtigo(e);

		fachada.compartilharMaterial(ar);
		fachada.compartilharMaterial(e);
		Assert.assertEquals(2, fachada.pesquisarMateriaisCompartilhados()
				.size());
		fachada.eliminarMaterialImproprio(ar);
		Assert.assertEquals(1, fachada.pesquisarMateriaisCompartilhados()
				.size());
	}	
}
