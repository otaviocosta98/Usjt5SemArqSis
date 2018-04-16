package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Cliente;
import br.usjt.arqsw.entity.Fila;
import br.usjt.arqsw.entity.Reqres;

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
		dao.fecharChamado(chamados);
	}

	public List<Cliente> listaClientes() {
		RestTemplate template = new RestTemplate();
		Reqres reqres = template.getForObject("https://reqres.in/api/users?per_page=15&page=1", Reqres.class);
		return reqres.getData();
	}
}
