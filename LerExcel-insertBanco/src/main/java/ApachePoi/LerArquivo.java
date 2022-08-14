package ApachePoi;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import models.LojasZaffari;

public class LerArquivo {
	
	private String caminhoArquivo;
	
	
	public LerArquivo(String arquivo) {
		
		this.caminhoArquivo = arquivo;
	}

	public List<LojasZaffari> LerExcelXLSX() {
		
		List<LojasZaffari> listLojas = new ArrayList<LojasZaffari>();
		
		try {
			
			/*faz a leitura do arquivo*/
			FileInputStream entrada = new FileInputStream(new File(caminhoArquivo));
			
			//HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); /*prepara a entrada do arquivo excel para realizar a leitura*/
			//HSSFSheet planilha = hssfWorkbook.getSheetAt(0); /*pega a primeira planilha do excel*/
			
			XSSFWorkbook hssfWorkbook = new XSSFWorkbook(entrada);
			XSSFSheet planilha = hssfWorkbook.getSheetAt(0);
			
			Iterator<Row> linhaIterator = planilha.iterator();
			
	
		
			while (linhaIterator.hasNext()) /*Enquanto tiver dados no arquivo*/{
				
				Row linha = linhaIterator.next(); /*Dados na linha*/
				
				Iterator<Cell> celulas = linha.iterator();
				
				LojasZaffari lojasZaffari = new LojasZaffari();
				
				while(celulas.hasNext())/*percorre enquanto tiver as celulas*/ {
					
					Cell cell = celulas.next();
					
					switch (cell.getColumnIndex()) {
					case 0:
						lojasZaffari.setLojasNumero(cell.getStringCellValue());
						break;
					case 1:
						lojasZaffari.setNomeLocal(cell.getStringCellValue());
						break;
					case 2:
						lojasZaffari.setEndereco(cell.getStringCellValue());
						break;
						
					}/*fechamento do switch*/
					
				}/*fechamento da celulas*/
				
				listLojas.add(lojasZaffari);
			}
			
			entrada.close();
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
			System.out.println("arquivo não encontrado!");
		}
			
		return listLojas;
		
	}
	
	
}
