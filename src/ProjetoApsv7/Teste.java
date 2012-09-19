package ProjetoApsv7;

import java.io.File;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Teste {

	Fachada fachada;
	@Before
	public void removerAquivoBin() {
		File file = new File("arquivo.bin");
		if (file.exists()) {
			file.delete();
		}
		GerenteDePersistencia.reset();
		fachada = new Fachada();
	}
	

	@Test
	public void cadastrarAdministrador() {

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);

		List<Administrador> admin = fachada.listarAdminitradores();
		Administrador aCadastrado = admin.get(0);
		Assert.assertEquals(aCadastrado,a);
	}

	@Test
	public void cadastrarUsuario() {

		Usuario u = criarUsuarioPadrao();
		fachada.cadastrarUsuario(u);

		List<Usuario> usuarios = fachada.listarUsuario();
		Usuario aCadastrado = usuarios.get(0);
		Assert.assertEquals(aCadastrado,u);
	}

	@Test
	public void aprovarCadastroUsuario() {

		criaCadastraElogaAdministrador();

		Usuario u = criarUsuarioPadrao();
		fachada.cadastrarUsuario(u);

		List<Usuario> usuarios = fachada.listarUsuario();
		Usuario aCadastrado = usuarios.get(0);
		Assert.assertEquals(aCadastrado,u);
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

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);

		Usuario u = criarUsuarioPadrao();
		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
	}

	@Test
	public void inserirArtigo() {

		criaCadastraElogaAdministrador();

		Usuario u = criarUsuarioPadrao();

		
		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.getLogin(), u.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);
		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		Assert.assertEquals(aCadastrado,ar);
		int size = artigos.size();
		Assert.assertEquals(1, size);
	}

	@Test
	public void removerArtigo() {

		criaCadastraElogaAdministrador();
		
		Usuario u = criarUsuarioPadrao();

		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.getLogin(), u.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);
		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		Assert.assertEquals(aCadastrado,ar);
		fachada.removerArtigo(ar);
		int size = artigos.size();
		Assert.assertEquals(0, size);
	}

	@Test
	public void pesquisarArtigoAutor() {

		criaCadastraElogaAdministrador();
		
		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		Artigo e = criarArtigoPadrao2();
		fachada.adicionarArtigo(e);

		List<Artigo> artigos = fachada.listarArtigo();

		Artigo aCadastrado = artigos.get(0);
		String nome = "Nome";

		List<Artigo> autores = fachada.pesquisarPorAutor(nome);
		aCadastrado = autores.get(0);
		Assert.assertEquals(aCadastrado,ar);
		Assert.assertEquals(1, autores.size());
	}

	@Test
	public void pesquisarArtigoTitulo() {

		criaCadastraElogaAdministrador();
		
		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		Artigo e = criarArtigoPadrao2();
		fachada.adicionarArtigo(e);

		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		String titulo = "titulo";

		List<Artigo> titulos = fachada.pesquisarArtigoPorTitulo(titulo);
		aCadastrado = titulos.get(0);
		Assert.assertEquals(aCadastrado,ar);
		Assert.assertEquals(1, titulos.size());
	}

	@Test
	public void pesquisarArtigoPorPalavra() {

		String palavra = "resumo";
		
		criaCadastraElogaAdministrador();
		
		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		Artigo e = criarArtigoPadrao2();
		fachada.adicionarArtigo(e);

		List<Artigo> artigos = fachada.listarArtigo();
		Artigo aCadastrado = artigos.get(0);
		fachada.pesquisarArtigoPorPalavra(palavra);

		List<Artigo> palavras = fachada.pesquisarArtigoPorPalavra(palavra);
		aCadastrado = palavras.get(0);
		Assert.assertEquals(aCadastrado,ar);
		Assert.assertEquals(1, palavras.size());
	}

	@Test
	public void compartilharMaterial() {

		criaCadastraElogaAdministrador();
		
		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		List<Artigo> artigos = fachada.listarArtigo();
		fachada.compartilharMaterial(ar);
		
		Usuario u=criarUsuarioPadrao();
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.login, u.senha);
		
		artigos=fachada.listarArtigosCompartilhados();
		int size = artigos.size();
		Assert.assertEquals(1, size);
	}

	@Test
	public void pesquisarMateriaisCompartilhados() {

		criaCadastraElogaAdministrador();

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);

		fachada.compartilharMaterial(ar);
		Assert.assertEquals(1, fachada.pesquisarMateriaisCompartilhados()
				.size());
	}

	@Test
	public void pesquisarMateriaisCompartilhadosPorAutor() {

		criaCadastraElogaAdministrador();

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
		Assert.assertEquals(aCadastrado,ar);
		Assert.assertEquals(1, autores.size());
	}

	@Test
	public void pesquisarMateriaisCompartilhadosPorTitulo() {

		criaCadastraElogaAdministrador();

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
		Assert.assertEquals(aCadastrado,ar);
		Assert.assertEquals(1, titulos.size());
	}

	@Test
	public void pesquisarMateriaisCompartilhadosPorPalavra() {

		criaCadastraElogaAdministrador();

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
		Assert.assertEquals(aCadastrado,ar);
		Assert.assertEquals(1, palavras.size());
	}

	@Test
	public void eliminarMaterialImproprioCompartilhado() {

		criaCadastraElogaAdministrador();
		
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

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);
		fachada.cadastrarAdministrador(a);

		List<Administrador> admin = fachada.listarAdminitradores();
		Administrador aCadastrado = admin.get(0);
		Assert.assertEquals(aCadastrado,a);
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void naoAprovarCadastroUsuario() {

		criaCadastraElogaAdministrador();
		
		Usuario u = criarUsuarioPadrao();
		fachada.cadastrarUsuario(u);

		List<Usuario> usuarios = fachada.listarUsuarioAprovado();

		Assert.assertEquals(0, usuarios.size());
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void inserirMesmoArtigo() {

		criaCadastraElogaAdministrador();

		Usuario u = criarUsuarioPadrao();

		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.getLogin(), u.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.adicionarArtigo(ar);
		fachada.adicionarArtigo(ar);
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void removerArtigoInexistente() {

		criaCadastraElogaAdministrador();
		
		Usuario u = criarUsuarioPadrao();

		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.getLogin(), u.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.removerArtigo(ar);
	}

	@Test
	public void ConsultaPersistencia() {

		Administrador a = criarAdministradorPadrao();
		fachada.cadastrarAdministrador(a);

		fachada = new Fachada();

		List<Administrador> admin = fachada.listarAdminitradores();
		Administrador aCadastrado = admin.get(0);
		Assert.assertTrue(aCadastrado.metodoCompare(a));
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void cadastrarMesmoUsuario() {

		Usuario u = criarUsuarioPadrao();
		fachada.cadastrarUsuario(u);
		fachada.cadastrarUsuario(u);

		List<Usuario> usuarios = fachada.listarUsuario();
		Usuario aCadastrado = usuarios.get(0);
		Assert.assertEquals(aCadastrado,u);
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void usuarioAprovaCadastro() {

		Usuario u = criarUsuarioPadrao();
		fachada.cadastrarUsuario(u);

		Usuario a = criarUsuarioPadrao();
		fachada.cadastrarUsuario(a);

		List<Usuario> usuarios = fachada.listarUsuario();
		Usuario aCadastrado = usuarios.get(0);
		Assert.assertEquals(aCadastrado,u);
		fachada.aprovarCadastoUsuario(u);
				
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void removerArtigoJaRemovido() {

		criaCadastraElogaAdministrador();
		
		Usuario u = criarUsuarioPadrao();

		fachada.cadastrarUsuario(u);
		fachada.aprovarCadastoUsuario(u);
		fachada.login(u.getLogin(), u.getSenha());

		Artigo ar = criarArtigoPadrao1();
		fachada.removerArtigo(ar);
		fachada.removerArtigo(ar);
	}

	@Test(expected = GerenciadorDeArtigosException.class)
	public void loginInvalido() {

		criaCadastraElogaAdministrador();
		
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

		criaCadastraElogaAdministrador();

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

		criaCadastraElogaAdministrador();

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

		criaCadastraElogaAdministrador();

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

		criaCadastraElogaAdministrador();

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

		criaCadastraElogaAdministrador();

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

		criaCadastraElogaAdministrador();
		
		Usuario u = criarUsuarioPadrao();

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
	
	private void criaCadastraElogaAdministrador(){

	Administrador a = criarAdministradorPadrao();
	fachada.cadastrarAdministrador(a);
	fachada.login(a.login, a.senha);
	 		
	}
}
