package br.com.trabalhocarro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.trabalhocarro.domain.Carro;


@Repository
public interface CarroRepository extends JpaRepository<Carro,Integer>{

	public Optional<Carro> findByOdometroGreaterThan(double km);
	public Optional<Carro> findByDiariaLessThan(double diaria);
	public Optional<Carro> findByAnoBetween(Integer anoIni, Integer anoFim);

}
	