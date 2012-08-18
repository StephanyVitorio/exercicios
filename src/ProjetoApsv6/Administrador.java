package ProjetoApsv6;


public class Administrador extends Pessoa {

	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public boolean temPermissaoAdministrativa() {
		return true;
	}
	
	public boolean metodoCompare(Pessoa u ){
		if (this.end.equals(u.getEnd()) && this.nome.equals(u.getNome()) 
				 && this.login.equals(u.getLogin()) && this.senha.equals(u.getSenha())
				 &&(this.id.equals(getId()))){
			    return true;
			}
			return false;
	}
}
