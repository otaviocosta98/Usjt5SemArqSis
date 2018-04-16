package br.usjt.arqsw.dao;

import static java.lang.Integer.parseInt;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

/**
 * 
 * @author Otávio Augusto Soares Costa - 816118924
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class ChamadoDAO {

	@PersistenceContext
	EntityManager manager;

	public List<Chamado> listarChamados(Fila fila) throws IOException {
		fila = manager.find(Fila.class, fila.getId());
		Query query = manager.createQuery("select c from Chamado c where c.idFila = :fila");
		query.setParameter("fila", fila);
		return (List<Chamado>) query.getResultList();
	}

	public int novoChamado(Chamado chamado) throws IOException {
		manager.persist(chamado);
		return chamado.getIdChamado();
	}

	public List<Chamado> listarChamados() throws IOException {
		return manager.createQuery("select c from Chamado c").getResultList();
	}

	public List<Chamado> listarChamadosAbertos(Fila fila) throws IOException {
		fila = manager.find(Fila.class, fila.getId());
		Query query = manager.createQuery("select c from Chamado c where c.idFila = :fila and status = 'ABERTO'");
		query.setParameter("fila", fila);
		return (List<Chamado>) query.getResultList();
	}

	public void fecharChamado(String[] chamados) throws IOException {
		for (String idChamado : chamados) {
			Chamado chamado = carregar(parseInt(idChamado));
			chamado.setStatus(Chamado.FECHADO);
			chamado.setDtFechamento(new Date());
			manager.merge(chamado);
		}

	}

	public Chamado carregar(int idChamado) throws IOException {
		return manager.find(Chamado.class, idChamado);
	}

}
