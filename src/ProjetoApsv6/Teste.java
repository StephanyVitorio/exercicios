package ProjetoApsv6;

import java.io.File;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Teste {

	@Before
	public void removerAquivoBin() {
		File file = new File("arquivo.bin");
		if (file.exists()) {
			file.delete();
		}
		GerenteDePersistencia.reset();
	}

	@Test
	public void cadastrarAdministrador() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);

		List<Administrador> admin = fachada.listarAdminitradores();
		Administrador aCadastrado = admin.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(a));
	}

	@Test
	public void cadastrarUsuario() {
		Fachada fachada = new Fachada();

		Usuario u = criarUsuarioPadrao();
		fachada.cadastrarUsuario(u);

		List<Usuario> usuarios = fachada.listarUsuario();
		Usuario aCadastrado = usuarios.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(u));
	}

	@Test
	public void aprovarCadastroUsuario() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Usuario u = criarUsuarioPadrao();
		fachada.cadastrarUsuario(u);

		List<Usuario> usuarios = fachada.listarUsuario();
		Usuario aCadastrado = usuarios.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(u));
		fachada.aprovarCadastoUsuario(u);
		usuarios = fachada.listarUsuario();
		List<Usuario> usuariosAprovados = fachada.listarUsuarioAprovado();
		int sizeAprovados = usuariosAprovados.size();
		int sizeUsuarios = usuarios.size();
		Assert.assertEquals(1, sizeAprovados);
		Assert.assertEquals(0, sizeUsuarios);
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void aprovarCadastroUsuarioSemLogin() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);

		Usuario u = criarUsuarioPadrao();
		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
	}

	@Test
	public void inserirArtigo() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);

		Usuario u = criarUsuarioPadrao();

		fachada.login(a.getLogin(), a.getSenha());
		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.getLogin(), u.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);
		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(ar));
		int size = artigos.size();
		Assert.assertEquals(1, size);
	}

	@Test
	public void removerArtigo() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);

		Usuario u = criarUsuarioPadrao();

		fachada.login(a.getLogin(), a.getSenha());
		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.getLogin(), u.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);
		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(ar));
		fachada.removerArtigo(ar);
		int size = artigos.size();
		Assert.assertEquals(0, size);
	}

	@Test
	public void pesquisarArtigoAutor() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		Artigo e = criarArtigoPadrao2();
		fachada.adicionarArtigo(e);

		List<Artigo> artigos = fachada.listarArtigo();

		Artigo aCadastrado = artigos.get(0);
		String nome = "Nome";

		List<Artigo> autores = fachada.pesquisarPorAutor(nome);
		aCadastrado = autores.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(ar));
		Assert.assertEquals(1, autores.size());
	}

	@Test
	public void pesquisarArtigoTitulo() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		Artigo e = criarArtigoPadrao2();
		fachada.adicionarArtigo(e);

		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		String titulo = "titulo";

		List<Artigo> titulos = fachada.pesquisarArtigoPorTitulo(titulo);
		aCadastrado = titulos.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(ar));
		Assert.assertEquals(1, titulos.size());
	}

	@Test
	public void pesquisarArtigoPorPalavra() {
		Fachada fachada = new Fachada();

		String palavra = "resumo";
		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		Artigo e = criarArtigoPadrao2();
		fachada.adicionarArtigo(e);

		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		fachada.pesquisarArtigoPorPalavra(palavra);

		List<Artigo> palavras = fachada.pesquisarArtigoPorPalavra(palavra);
		aCadastrado = palavras.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(ar));
		Assert.assertEquals(1, palavras.size());
	}

	@Test
	public void compartilharMaterial() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		List<Artigo> artigos = fachada.listarArtigo();
		fachada.compartilharMaterial(ar);
		fachada.listarArtigo();
		int size = artigos.size();
		Assert.assertEquals(1, size);
	}

	@Test
	public void pesquisarMateriaisCompartilhados() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		fachada.compartilharMaterial(ar);
		Assert.assertEquals(1, fachada.pesquisarMateriaisCompartilhados()
				.size());
	}

	@Test
	public void pesquisarMateriaisCompartilhadosPorAutor() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		Artigo e = criarArtigoPadrao2();
		fachada.adicionarArtigo(e);

		fachada.compartilharMaterial(ar);
		fachada.compartilharMaterial(e);

		List<Artigo> artigos = fachada.pesquisarMateriaisCompartilhados();

		Artigo aCadastrado = artigos.get(0);
		String nome = "Nome";

		List<Artigo> autores = fachada
				.pesquisarMateriaisCompartilhadosPorAutor(nome);
		aCadastrado = autores.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(ar));
		Assert.assertEquals(1, autores.size());
	}

	@Test
	public void pesquisarMateriaisCompartilhadosPorTitulo() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		Artigo e = criarArtigoPadrao2();
		fachada.adicionarArtigo(e);

		fachada.compartilharMaterial(ar);
		fachada.compartilharMaterial(e);

		List<Artigo> artigos = fachada.pesquisarMateriaisCompartilhados();

		Artigo aCadastrado = artigos.get(0);
		String titulo = "titulo";

		List<Artigo> titulos = fachada
				.pesquisarMateriaisCompartilhadosPorTitulo(titulo);
		aCadastrado = titulos.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(ar));
		Assert.assertEquals(1, titulos.size());
	}

	@Test
	public void pesquisarMateriaisCompartilhadosPorPalavra() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		Artigo e = criarArtigoPadrao2();
		fachada.adicionarArtigo(e);

		fachada.compartilharMaterial(ar);
		fachada.compartilharMaterial(e);

		List<Artigo> artigos = fachada.pesquisarMateriaisCompartilhados();

		Artigo aCadastrado = artigos.get(0);
		String palavra = "resumo";

		List<Artigo> palavras = fachada
				.pesquisarMateriaisCompartilhadosPorPalavra(palavra);
		aCadastrado = palavras.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(ar));
		Assert.assertEquals(1, palavras.size());
	}

	@Test
	public void eliminarMaterialImproprioCompartilhado() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
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

	@Test(expected = GerenciadorDeArtigosException.class)
	public void cadastrarMesmoAdministrador() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.cadastrarAdministrador(a);

		List<Administrador> admin = fachada.listarAdminitradores();
		Administrador aCadastrado = admin.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(a));
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void naoAprovarCadastroUsuario() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Usuario u = criarUsuarioPadrao();
		fachada.cadastrarUsuario(u);

		List<Usuario> usuarios = fachada.listarUsuarioAprovado();

		Assert.assertEquals(0, usuarios.size());
		usuarios = fachada.listarUsuario();
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void inserirMesmoArtigo() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);

		Usuario u = criarUsuarioPadrao();

		fachada.login(a.getLogin(), a.getSenha());
		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.getLogin(), u.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);
		fachada.adicionarArtigo(ar);
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void removerArtigoInexistente() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);

		Usuario u = criarUsuarioPadrao();

		fachada.login(a.getLogin(), a.getSenha());
		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.getLogin(), u.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.removerArtigo(ar);
	}

	@Test
	public void ConsultaPersistencia() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);

		fachada = new Fachada();

		List<Administrador> admin = fachada.listarAdminitradores();
		Administrador aCadastrado = admin.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(a));
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void cadastrarMesmoUsuario() {
		Fachada fachada = new Fachada();

		Usuario u = criarUsuarioPadrao();
		fachada.cadastrarUsuario(u);
		fachada.cadastrarUsuario(u);

		List<Usuario> usuarios = fachada.listarUsuario();
		Usuario aCadastrado = usuarios.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(u));
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void usuarioAprovaCadastro() {
		Fachada fachada = new Fachada();

		Usuario u = criarUsuarioPadrao();
		fachada.cadastrarUsuario(u);

		Usuario a = criarUsuarioPadrao();
		fachada.cadastrarUsuario(a);

		List<Usuario> usuarios = fachada.listarUsuario();
		Usuario aCadastrado = usuarios.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(u));
		fachada.aprovarCadastoUsuario(u);
		usuarios = fachada.listarUsuario();
		List<Usuario> usuariosAprovados = fachada.listarUsuarioAprovado();
		int sizeAprovados = usuariosAprovados.size();
		int sizeUsuarios = usuarios.size();
		Assert.assertEquals(1, sizeAprovados);
		Assert.assertEquals(0, sizeUsuarios);
	}



	@Test(expected = GerenciadorDeArtigosException.class)
	public void removerArtigoJaRemovido() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);

		Usuario u = criarUsuarioPadrao();

		fachada.login(a.getLogin(), a.getSenha());
		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.getLogin(), u.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.removerArtigo(ar);
		fachada.removerArtigo(ar);
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void loginInvalido() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Usuario u = criarUsuarioPadrao();
		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);

		Usuario e = criarUsuarioPadrao2();
		fachada.cadastrarUsuario(e);
		fachada.aprovarCadastoUsuario(e);
		fachada.login(e.getLogin(), u.getSenha());
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void loginUsuarioJaExistente() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Usuario u = new Usuario();
		u.setNome("usuario2");
		u.setEnd("Rua2");
		u.setInstituicao("ufpb");
		u.setLogin("adm");
		u.setSenha("senha2");

		fachada.cadastrarUsuario(u);
	}

	@Test
	public void removerArtigoCompartilhado() {
		Fachada fachada = new Fachada();
		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		List<Artigo> artigos = fachada.listarArtigosCompartilhados();
		fachada.compartilharMaterial(ar);
		fachada.listarArtigosCompartilhados();
		int size = artigos.size();
		Assert.assertEquals(1, size);

		fachada.removerArtigoCompartilhado(ar);
		artigos = fachada.listarArtigosCompartilhados();
		int size1 = artigos.size();
		Assert.assertEquals(0, size1);
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void pesquisarArtigoSemAutor() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		Artigo e = criarArtigoPadrao2();
		fachada.adicionarArtigo(e);

		fachada.listarArtigo();
		String nome = null;
		fachada.pesquisarPorAutor(nome);
	}
	
	@Test(expected = GerenciadorDeArtigosException.class)
	public void pesquisarArtigoSemPalavra() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		Artigo e = criarArtigoPadrao2();
		fachada.adicionarArtigo(e);

		fachada.listarArtigo();
		String palavra = null;
		fachada.pesquisarArtigoPorPalavra(palavra);
	}
	
	@Test(expected = GerenciadorDeArtigosException.class)
	public void pesquisarArtigoSemTitulo() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.login(a.getLogin(), a.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		Artigo e = criarArtigoPadrao2();
		fachada.adicionarArtigo(e);

		fachada.listarArtigo();
		String titulo = null;
		fachada.pesquisarArtigoPorTitulo(titulo);
	}
	
	@Test
	public void pesquisarArtigoInexistentePorPalavra() {
		Fachada fachada = new Fachada();

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);

		Usuario u = criarUsuarioPadrao();

		fachada.login(a.getLogin(), a.getSenha());
		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.getLogin(), u.getSenha());

		List<Artigo> l = fachada.pesquisarArtigoPorPalavra("hh");
		Assert.assertEquals(0, l.size());
	}
	
	private Administrador criarAdministradorPadrao() {
		Administrador a = new Administrador();
		a.setNome("Ste");
		a.setId("12345");
		a.setEnd("Rua1");
		a.setLogin("adm");
		a.setSenha("senha");
		return a;
	}

	private Artigo criarArtigoPadrao1() {
		Artigo ar = new Artigo();
		ar.setNome("Nome");
		ar.setCaminho("url");
		ar.setTitulo("titulo");
		ar.setResumo("resumo");
		return ar;
	}

	private Artigo criarArtigoPadrao2() {
		Artigo e = new Artigo();
		e.setNome("ABC");
		e.setCaminho("caminho");
		e.setTitulo("Aps");
		e.setResumo("casa");
		return e;
	}

	private Usuario criarUsuarioPadrao() {
		Usuario u = new Usuario();
		u.setNome("usuario1");
		u.setEnd("Rua1");
		u.setInstituicao("ufpb");
		u.setLogin("adm1");
		u.setSenha("senha");
		return u;
	}

	private Usuario criarUsuarioPadrao2() {
		Usuario u = new Usuario();
		u.setNome("usuario2");
		u.setEnd("Rua2");
		u.setInstituicao("ufpb");
		u.setLogin("adm2");
		u.setSenha("senha2");
		return u;
	}
}
