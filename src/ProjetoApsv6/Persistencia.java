package ProjetoApsv6;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Persistencia implements Serializable{

	List<Artigo> artigos = new LinkedList<Artigo>();
	protected List<Usuario> usuariosPendentes = new LinkedList<Usuario>();
	protected List<Pessoa> usuarios = new LinkedList<Pessoa>();
	
}


	
	
