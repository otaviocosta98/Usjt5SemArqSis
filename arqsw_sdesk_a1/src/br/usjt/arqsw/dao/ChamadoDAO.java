package br.usjt.arqsw.dao;

import java.io.IOException;
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
public class ChamadoDAO {

	@PersistenceContext
	EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Chamado> listarChamados(Fila fila) throws IOException {
		fila = manager.find(Fila.class, fila.getId());
		Query query = manager.createQuery("select c from Chamado c where c.idFila = :fila");
		query.setParameter("fila", fila);
		return (List<Chamado>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public int novoChamado(Chamado chamado) throws IOException {
		manager.persist(chamado);
		Query query = manager.createQuery("select c from Chamado c");
		List<Chamado> chamados = (List<Chamado>) query.getResultList();
		return chamados.get(chamados.size() - 1).getIdChamado();
	}

}
