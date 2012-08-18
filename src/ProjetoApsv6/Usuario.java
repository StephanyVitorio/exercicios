package ProjetoApsv6;

public  class Usuario extends Pessoa {

	String instituicao;

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public boolean metodoCompare(Pessoa u ){
		{
			 if (this.end.equals(u.getEnd()) && this.nome.equals(u.getNome()) 
					 && this.login.equals(u.getLogin()) && this.senha.equals(u.getSenha())
					 &&this.instituicao.equals(getInstituicao())){
				    return true;
				}
				return false;
		
		}
	}
}
