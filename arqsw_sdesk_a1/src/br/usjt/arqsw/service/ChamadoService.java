package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Otávio Augusto Soares Costa - 816118924
 *
 */
public class ChamadoService {

	private ChamadoDAO dao;

	public ChamadoService() {
		dao = new ChamadoDAO();
	}

	public int novoChamado(Chamado chamado) throws IOException {
		return dao.novoChamado(chamado);
	}

	public ArrayList<Chamado> listarChamados(Fila Fila) throws IOException {
		return dao.listarChamados(Fila);
	}
}
