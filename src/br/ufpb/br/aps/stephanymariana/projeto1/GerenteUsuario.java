package br.ufpb.br.aps.stephanymariana.projeto1;
import java.util.LinkedList;
import java.util.List;


public class GerenteUsuario {
	
	private List<Usuario> usuarioPendente = new LinkedList<Usuario>();
	private List<Usuario> usuarioAprovado = new LinkedList<Usuario>();
	private List<Administrador> admin = new LinkedList<Administrador>();
	
	public Usuario login (String nome, String senha){
		for (Usuario usu: usuarioAprovado){
			if (usu.login(nome, senha)){
				return usu;
			}
		}
		
		return null;
	}
	
	public void cadastrarUsuario(Usuario u) {		
		usuarioPendente.add(u);
	}

	public void cadastrarAdministrador(Administrador a) {				
		admin.add(a);			
	}
	
	public void aprovarCadastoUsuario(Usuario u) {		
		usuarioAprovado.add(u);				
		usuarioPendente.remove(u);			
	}
	
	public List<Administrador> getListAdministrador(){
		return admin;
	}
	public List<Usuario> getListUsuario(){
		return usuarioPendente;
	}
	
	public List<Usuario> getListUsuarioAprovado(){
		return usuarioAprovado;
	}
}
