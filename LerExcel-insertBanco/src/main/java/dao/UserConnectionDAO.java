package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import conexaoJDBC.SingleConnection;
import models.LojasZaffari;

public class UserConnectionDAO {
	
	private Connection conexao;
	
	public UserConnectionDAO() {
		
		conexao = SingleConnection.getConnecntion();
	}
	
	public void InsertBanco(LojasZaffari lojas ) {
		
		try {
			
			String sql = "INSERT INTO public.lojas_zaffari(lojas_numero, nome_local, endereco) VALUES (?, ?, ?)";
			PreparedStatement insert = conexao.prepareStatement(sql);
			insert.setString(1, lojas.getLojasNumero());
			insert.setString(2, lojas.getNomeLocal());
			insert.setString(3, lojas.getEndereco());
			insert.execute();
			conexao.commit();/*Salva no banco*/
			
			
		} catch (SQLException e) {
			try {
				conexao.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}
