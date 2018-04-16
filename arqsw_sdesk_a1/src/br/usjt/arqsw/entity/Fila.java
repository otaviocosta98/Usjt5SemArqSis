package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Otávio Augusto Soares Costa - 816118924
 *
 */
@Entity
public class Fila implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fila")
	private int id;

	@Column(name = "nm_fila")
	@NotNull(message = "O nome não pode ser vazio")
	@Size(min = 5, max = 45, message = "O nome da fila deve estar entre 5 e 45 caracteres.")
	private String nome;

	@Column(name = "caminho_figura")
	private String caminhoFigura;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaminhoFigura() {
		return caminhoFigura;
	}

	public void setCaminhoFigura(String caminhoFigura) {
		this.caminhoFigura = caminhoFigura;
	}

	@Override
	public String toString() {
		return "Fila [id=" + id + ", nome=" + nome + ", caminhoFigura=" + caminhoFigura + "]";
	}

}
