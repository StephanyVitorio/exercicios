package br.ufpb.aps.stephany.exercicio;


public class ValidadorNumerico implements Validador {

	private int min;
	private int max;
	
	public ValidadorNumerico(int min,int max){
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void validar(String valor) throws ValorInvalidoException{
		try{
			int v = Integer.parseInt(valor);
			if(v < min)
				throw new ValorInvalidoException("valor eh minimo de idade eh "+min);
			if(v > max)
				throw new ValorInvalidoException("valor maximo de idade eh "+max);
		}catch(NumberFormatException e){
			throw new ValorInvalidoException("valor nao eh um inteiro");
		}
		

	}

}
