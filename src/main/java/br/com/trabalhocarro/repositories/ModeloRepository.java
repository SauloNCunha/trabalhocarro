package br.com.trabalhocarro.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trabalhocarro.domain.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository <Modelo, Integer>{
	Optional<Modelo> findByDescricao(String descricao);	

}
