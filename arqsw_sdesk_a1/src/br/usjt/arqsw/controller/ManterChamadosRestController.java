package br.usjt.arqsw.controller;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.service.ChamadoService;
import br.usjt.arqsw.service.FilaService;

@RestController
public class ManterChamadosRestController {

	@Autowired
	private ChamadoService chamadoService;

	@Autowired
	private FilaService filaService;

	@RequestMapping(method = RequestMethod.GET, value = "rest/chamados")
	public @ResponseBody List<Chamado> listarChamados() {
		try {
			return chamadoService.listarChamados();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "rest/chamado")
	public ResponseEntity<Chamado> inserirChamado(@RequestBody Chamado chamado) {
		try {
			int id = chamadoService.novoChamado(chamado);
			chamado.setIdChamado(id);
			return new ResponseEntity<>(chamado, HttpStatus.CREATED);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(chamado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
