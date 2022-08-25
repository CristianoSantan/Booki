package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelo.Autores;
import modelo.Editoras;
import modelo.Livros;

public class LivroDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	public void save(Livros livro) {
		String sql = "INSERT INTO livros " + "(nome_livro, preco_livro, publicacao_livro, id_editora, id_autor) "
				+ "values(?, ?, ?, ?, ?);";

		try {
			// Cria uma conexão com o banco
			conn = ConnectionMySQL.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, livro.getNome());

			pstm.setDouble(2, livro.getPreco());

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setDate(3, new Date(formatter.parse(livro.getPublicacao()).getTime()));

			pstm.setInt(4, livro.getEditoras().getId());

			pstm.setInt(5, livro.getAutores().getId());

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
	public List<Livros> getLivros() {
		String sql = "select * from livros_completo;";

		List<Livros> livros = new ArrayList<Livros>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Livros livro = new Livros();
				Autores autor = new Autores();
				Editoras editora = new Editoras();

				livro.setId(rset.getInt("id_livro"));

				livro.setNome(rset.getString("nome_livro"));

				livro.setPreco(rset.getDouble("preco_livro"));

				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				livro.setPublicacao(dateFormat.format(rset.getDate("publicacao_livro")));

				autor.setId(rset.getInt("id_autor"));

				autor.setNome(rset.getString("nome_autor"));

				livro.setAutores(autor);

				editora.setId(rset.getInt("id_editora"));

				editora.setNome(rset.getString("nome_editora"));

				livro.setEditoras(editora);

				livros.add(livro);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
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

		return livros;
	}
	// Metodo pra atualizar

	public void update(Livros livro1) {
		String sql = "UPDATE livros SET nome_livro = ?, preco_livro = ?, publicacao_livro = ?, id_autor = ?, id_editora = ? WHERE id_livro = ?;";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, livro1.getNome());

			pstm.setDouble(2, livro1.getPreco());

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			pstm.setDate(3, new Date(formatter.parse(livro1.getPublicacao()).getTime()));

			pstm.setInt(4, livro1.getAutores().getId());
			
			pstm.setInt(5, livro1.getEditoras().getId());

			pstm.setInt(6, livro1.getId());

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

	// Metodo para deletar
	public void deleteById(int id) {
		String sql = "DELETE FROM livros WHERE id_livro = ?";

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

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

	public Livros getLivroById(int id) {
		String sql = "select * from livros_completo WHERE id_livro = ?;";

		Livros livro = new Livros();
		Autores autor = new Autores();
		Editoras editora = new Editoras();

		ResultSet rset = null;

		try {
			conn = ConnectionMySQL.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			rset = pstm.executeQuery();

			rset.next();

			livro.setId(rset.getInt("id_livro"));

			livro.setNome(rset.getString("nome_livro"));

			livro.setPreco(rset.getDouble("preco_livro"));

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			livro.setPublicacao(dateFormat.format(rset.getDate("publicacao_livro")));

			autor.setId(rset.getInt("id_autor"));

			autor.setNome(rset.getString("nome_autor"));

			livro.setAutores(autor);

			editora.setId(rset.getInt("id_editora"));

			editora.setNome(rset.getString("nome_editora"));

			livro.setEditoras(editora);

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

		return livro;
	}
}
