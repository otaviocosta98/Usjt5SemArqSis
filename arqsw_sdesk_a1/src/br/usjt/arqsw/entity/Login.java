package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Otávio Augusto Soares Costa - 816118924
 *
 */
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "O campo username não deve estar vazio.")
	@Size(min = 5, max = 50, message = "O campo username deve conter de {min} até {max} catacteres.")
	private String username;

	@NotNull(message = "O campo password não deve estar vazio.")
	@Size(min = 5, max = 50, message = "O campo senha deve conter de {min} até {max} catacteres.")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}

}
