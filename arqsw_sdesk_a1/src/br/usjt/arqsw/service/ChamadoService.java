package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Otávio Augusto Soares Costa - 816118924
 *
 */
@Service
public class ChamadoService {

	@Autowired
	private ChamadoDAO dao;

	public int novoChamado(Chamado chamado) throws IOException {
		chamado.setStatus(Chamado.ABERTO);
		chamado.setDtAbertura(new Date());
		return dao.novoChamado(chamado);
	}

	public List<Chamado> listarChamados(Fila Fila) throws IOException {
		return dao.listarChamados(Fila);
	}
}
