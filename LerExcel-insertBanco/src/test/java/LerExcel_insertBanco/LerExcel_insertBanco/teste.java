package LerExcel_insertBanco.LerExcel_insertBanco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import ApachePoi.LerArquivo;
import dao.UserConnectionDAO;
import models.LojasZaffari;

public class teste {

	@Test
	public void initConexao() {
		
		UserConnectionDAO conexao = new UserConnectionDAO();
		
	}
	@Test
	public void initLerAquivoExcel() {
		try {
			
		/*faz a conexao*/
		UserConnectionDAO dao = new UserConnectionDAO();
		
		LerArquivo arquivo = new LerArquivo("C:\\Users\\aless\\eclipse-workspace\\LerExcel-insertBanco\\src\\main\\java\\arquivosExcel\\LOJAS ZAFFARI.xlsx");
		
			List<LojasZaffari> listaLojasZaffari = new ArrayList<>();
			listaLojasZaffari = arquivo.LerExcelXLSX();
			
			Iterator<LojasZaffari> iteratorLojas = listaLojasZaffari.iterator();
			
			if(iteratorLojas.hasNext() == false) {
				
				System.out.println("Nenhum dados encontrado!");
				
			}else {
				
				/*faz a verificação para remover da lista*/
				
				for(int i = 0; i < listaLojasZaffari.size(); i++) {
					
					LojasZaffari lojas = listaLojasZaffari.get(i);
					
					if(lojas.getLojasNumero().equalsIgnoreCase("número") 
							|| lojas.getNomeLocal().equalsIgnoreCase("nome") 
							|| lojas.getEndereco().equalsIgnoreCase("endereço")) {
						
						//encontrou os nomes cadastrados
						
						listaLojasZaffari.remove(lojas);
						
						//sai do lop quando remover
						break;
					}
				}
				
				/*depois da verificação, vamos adicionar a lista no banco de dados*/
				
				for (LojasZaffari lojasZaffari : listaLojasZaffari) {
					
					dao.InsertBanco(lojasZaffari);
				}
				
				System.out.println(listaLojasZaffari.toString());
			}

			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
}
