package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Login;

/**
 * 
 * @author Otávio Augusto Soares Costa - 816118924
 *
 */
@Repository
public class LoginDAO {

	private Connection conn;

	@Autowired
	public LoginDAO(DataSource dataSource) throws IOException {
		try {
			this.conn = dataSource.getConnection();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}

	public boolean buscarLogin(Login login) throws IOException {
		String query = "select * from usuario where username = ? and password = ?";
		try (PreparedStatement pst = conn.prepareStatement(query)) {
			pst.setString(1, login.getUsername());
			pst.setString(2, login.getPassword());
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				throw new IOException(e);
			}
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}

}
