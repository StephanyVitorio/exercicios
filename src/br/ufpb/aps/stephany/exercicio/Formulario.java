package br.ufpb.aps.stephany.exercicio;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;


public class Formulario {
		
		private List<Campo> campos;
		private Map<String,Campo> mapcampo;
	
		
				
		public Formulario(){
			this.campos = new LinkedList<Campo>();
			this.mapcampo = new HashMap<String,Campo>();
		}
		
		public void addCampo(Campo campo){
			this.campos.add(campo);
		}
		
		public Campo listarItens(String a){
			Campo c =new Campo(a);
			mapcampo.put(a, c);
			return c;
		}
		
	
		public String menu(){
			String menu= "Sistema de Cadastro\n" + "[1]- Cadastrar\n" + 
		"[2]- Listar itens Cadastrados\n"+"[3]-Sair";
			
			return JOptionPane.showInputDialog(menu);
		}
		
		 public String menu2() {
				String menu2 = "Cadastro Finalizado \n" +
				"[C]- Continua " +
		                "[F]- Finaliza \n " ;
				return JOptionPane.showInputDialog(menu2);
			}
		
		 public void executar()  {

			 
				int opcao1 = Integer.parseInt(menu());
				while(opcao1 != 3) {
					switch (opcao1) {
					case 1 :
						obterdados();
						break;
					case 2:
						//MostraDados();
						break;
								                          }
					//opcao1 = Integer.parseInt(menu());
				}
			}
		
		 public void obterdados(){
				String opcao= menu();
				int op = Integer.parseInt(opcao);

			if(op==1){	
					
					
				
		           String nomep=JOptionPane.showInputDialog("Digite o seu nome");
		           Campo campotexto= new Campo(Campo.NOME,"Nome",nomep);        
		           campotexto.validar();
		            
		           while (campotexto.validar()== false){
		            	   nomep=JOptionPane.showInputDialog("Digite o seu nome");
				           campotexto.validar();
		            }
		            
		            
		            String email=JOptionPane.showInputDialog("Digite seu E-mail");
		            Campo campoemail= new Campo(Campo.EMAIL,"E-mail",email);        
				    campoemail.validar();
				    
				    while (campoemail.validar()== false){
		            	 email=JOptionPane.showInputDialog("Digite o seu Email");
				         campoemail.validar();
		            }
		            
		                   
				    String idade=JOptionPane.showInputDialog("Digite sua idade");	
				    Campo campoidade= new Campo(Campo.IDADE,"Idade",idade);        
				    campoidade.validar();
				    
				    while (campoidade.validar()== false){
		            	   idade=JOptionPane.showInputDialog("Digite o sua idade");
				           campoidade.validar();
		            }
		            
		                 
				    if ( campotexto.validar() && campoemail.validar() && campoidade.validar()){
				    	addCampo(campotexto);
				    	addCampo(campoemail);
				    	addCampo(campoidade);
				    }
		                    
				    String opcao2= menu2();
		            		int opc = Integer.parseInt(opcao2);
		            			 while(opc!= 3) {
		         					switch (opc) {
		         					case 1 :
		         						obterdados();
		         						break;
		         					case 2:
		         						//MostraDados();
		         						break;
		         				  }
		         					//opc = Integer.parseInt(menu());
		         				}
		            			 
		            			
		            		 }
				}
	
				
		 
	/*	 public void MostraDados(){
					String opcao= menu();
					int op = Integer.parseInt(opcao);

					if(op==2){	                   
			                    String itensCadastrados=JOptionPane.showInputDialog("Lista de Itens Cadastrados:\n");				    			
			                 }
				}*/

	}

