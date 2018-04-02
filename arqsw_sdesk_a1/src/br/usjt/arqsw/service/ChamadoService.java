package br.usjt.arqsw.service;

import static java.lang.Integer.parseInt;

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

	public List<Chamado> listarChamados() throws IOException {
		return dao.listarChamados();
	}

	public List<Chamado> listarChamadosAbertos(Fila fila) throws IOException {
		return dao.listarChamadosAbertos(fila);
	}

	public void fecharChamados(String[] chamados) throws IOException {
		for (String idChamado : chamados) {
			Chamado chamado = dao.carregar(parseInt(idChamado));
			dao.fecharChamado(chamado);
		}
	}
}
