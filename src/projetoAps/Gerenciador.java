package projetoAps;

import java.util.LinkedList;
import java.util.List;

public class Gerenciador {

	private List<Usuario> usuarioPendente = new LinkedList<Usuario>();
	private List<Pessoa> usuario = new LinkedList<Pessoa>();
	private GerenteArtigosCompartilhados artigosCompartilhados = new GerenteArtigosCompartilhados();

	public void cadastrarUsuario(Usuario u) {
		usuarioPendente.add(u);
	}

	public void cadastrarAdministrador(Administrador a) {
		usuario.add(a);
	}

	public Pessoa Login(String login, String senha) {
		for (Pessoa p : usuario) {
			if (p.login(login, senha)) {
				return p;
			}
		}
		throw new GerenciadorDeArtigosException(
				"O usuario não consta  na lista de usuarios aprovados");

	}

	public void aprovarCadastoUsuario(Usuario u) {
		usuario.add(u);
		usuarioPendente.remove(u);
	}

	public List<Administrador> getListAdministrador() {
		List<Administrador> adm = new LinkedList<Administrador>();
		for (Pessoa p : usuario) {
			if (p instanceof Administrador) {
				adm.add((Administrador) p);
			}
		}
		return adm;
	}

	public List<Usuario> getListUsuario() {
		return usuarioPendente;
	}

	public List<Usuario> getListUsuarioAprovado() {
		List<Usuario> usu = new LinkedList<Usuario>();
		for (Pessoa p : usuario) {
			if (p instanceof Usuario) {
				usu.add((Usuario) p);
			}
		}
		return usu;

	}

	public void compartilharArtigo(Artigo a) {
		artigosCompartilhados.compartilharMaterial(a);

	}
}
