package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Otávio Augusto Soares Costa - 816118924
 *
 */
public class Chamado implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ABERTO = "ABERTO";

	public static final String FECHADO = "FECHADO";

	private int idChamado;

	@NotNull(message = "O campo descricao não pode ser vazio")
	@Size(min = 5, max = 100, message = "O campo descricao deve conter entre {min} e {max} caracteres")
	private String descricao;

	private String status;

	private Date dtAbertura;

	private Date dtFechamento;

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
