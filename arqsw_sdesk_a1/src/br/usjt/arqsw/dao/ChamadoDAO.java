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

//	private Connection conn;
	
	@PersistenceContext
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<Chamado> listarChamados(Fila fila) throws IOException {
		fila = manager.find(Fila.class, fila.getId());
		
		String queryString = "select c from Chamado c where c.idFila = :fila";
		
		Query query = manager.createQuery(queryString);
		query.setParameter("fila", fila);
		List<Chamado> chamados = query.getResultList();
		return chamados;
	}
	
	@SuppressWarnings("unchecked")
	public int novoChamado(Chamado chamado) throws IOException {
		manager.persist(chamado);
		Query query = manager.createQuery("select c from Chamado c");
		List<Chamado> chamados = (List<Chamado>) query.getResultList();
		return chamados.get(chamados.size()-1).getIdChamado();
	}

//	@Autowired
//	public ChamadoDAO(DataSource dataSource) throws IOException {
//		try {
//			this.conn = dataSource.getConnection();
//		} catch (SQLException e) {
//			throw new IOException(e);
//		}
//	}
//
//	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException {
//		String query = "select * from fila f left join chamado c on c.id_fila = f.id_fila where c.id_fila = ?";
//		ArrayList<Chamado> chamados = new ArrayList<>();
//		try (PreparedStatement pst = conn.prepareStatement(query)) {
//			pst.setInt(1, fila.getId());
//			try (ResultSet rs = pst.executeQuery();) {
//				while (rs.next()) {
//					Chamado chamado = new Chamado();
//					chamado.setDescricao(rs.getString("descricao"));
//					chamado.setDtAbertura(rs.getDate("dt_abertura"));
//					chamado.setDtFechamento(rs.getDate("dt_fechamento"));
//					chamado.setIdChamado(rs.getInt("id_chamado"));
//					chamado.setStatus(rs.getString("status"));
//					chamado.setIdFila(fila);
//					chamados.add(chamado);
//				}
//			} catch (SQLException e) {
//				throw new IOException(e);
//			}
//		} catch (SQLException e) {
//			throw new IOException(e);
//		}
//		return chamados;
//	}
//
//	public int novoChamado(Chamado chamado) throws IOException {
//		String query = "insert into chamado(descricao, status, dt_abertura, id_fila) values (?, ?, ?, ?)";
//		int numeroChamado = -1;
//		try {
//			PreparedStatement pst = conn.prepareStatement(query);
//			pst.setString(1, chamado.getDescricao());
//			pst.setString(2, ABERTO);
//			pst.setDate(3, valueOf(now()));
//			pst.setInt(4, chamado.getIdFila().getId());
//			pst.execute();
//			query = "select id_chamado from chamado order by id_chamado desc limit 1";
//			pst = conn.prepareStatement(query);
//			ResultSet rs = pst.executeQuery();
//			if (rs.next()) {
//				numeroChamado = rs.getInt("id_chamado");
//			}
//		} catch (SQLException e) {
//			throw new IOException(e);
//		}
//		return numeroChamado;
//	}

}
