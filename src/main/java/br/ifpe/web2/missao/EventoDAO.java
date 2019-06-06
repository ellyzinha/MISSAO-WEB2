package br.ifpe.web2.missao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventoDAO extends JpaRepository<Eventos, Integer> {
	
	@Query("select e from Eventos e where UPPER(e.nome) like UPPER(CONCAT('%',:nomePesquisa, '%')) order by e.nome")
	public List<Eventos> findByNomeContainingIgnoreCase(String nomePesquisa);


}
