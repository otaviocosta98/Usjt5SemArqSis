package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Otávio Augusto Soares Costa - 816118924
 *
 */
@Entity
public class Chamado implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ABERTO = "ABERTO";

	public static final String FECHADO = "FECHADO";

	@Id
	@Column(name = "id_chamado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idChamado;

	@NotNull(message = "O campo descricao nÃ£o pode ser vazio")
	@Size(min = 5, max = 100, message = "O campo descricao deve conter entre {min} e {max} caracteres")
	private String descricao;

	private String status;

	@Column(name = "dt_abertura")
	private Date dtAbertura;

	@Column(name = "dt_fechamento")
	private Date dtFechamento;

	@ManyToOne
	@JoinColumn(name = "id_fila")
	private Fila idFila;

	public int getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(int idChamado) {
		this.idChamado = idChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtFechamento() {
		return dtFechamento;
	}

	public void setDtFechamento(Date dtFechamento) {
		this.dtFechamento = dtFechamento;
	}

	public Fila getIdFila() {
		return idFila;
	}

	public void setIdFila(Fila idFila) {
		this.idFila = idFila;
	}

	@Override
	public String toString() {
		return "Chamado [idChamado=" + idChamado + ", descricao=" + descricao + ", status=" + status + ", dtAbertura="
				+ dtAbertura + ", dtFechamento=" + dtFechamento + ", idFila=" + idFila + "]";
	}

}
