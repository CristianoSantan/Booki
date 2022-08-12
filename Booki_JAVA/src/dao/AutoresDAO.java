package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.ConnectionMySQL;
import modelo.Autores;

public class AutoresDAO {
	// Metodo pra salvar
	public void save(Autores autor) {
		String sql = "INSERT INTO autores (nome_autor) values(?);";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();
			
			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			
			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, autor.getNome());
			
			// Executar a sql para inserção dos dados
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// Metodo para Ler
	
	// Metodo pra atualizar
	
	// Metodo para deletar
	
}
