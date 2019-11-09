package br.com.trabalhocarro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.trabalhocarro.exception.DataIntegrityException;
import br.com.trabalhocarro.exception.ObjectNotFoundException;
import br.com.trabalhocarro.repositories.CarroRepository;

public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	public List<Carro> findAll(){
		return carroRepository.findAll();
	}
	
	public Carro findByID(Integer id) throws ObjectNotFoundException {
		Optional<Carro> carro = carroRepository.findById(id);
		return carro.orElseThrow(() ->
			new ObjectNotFoundException("Carro não encontrado! ID: "+ id));
		}
	
	
	public Carro kmSuperior(double km) throws ObjectNotFoundException{
		Optional<Carro> Carro = carroRepository.findByOdometroGreaterThan(km);
		return carro.orElseThrow(() ->
		new ObjectNotFoundException("Não encontrado um km superior que esse!"));
	}
	
	public Carro diariaInferior(double diaria) throws ObjectNotFoundException {
		Optional<Carro> carro = carroRepository.findByDiariaLessThan(diaria);
		return carro.orElseThrow(() ->
				new ObjectNotFoundException("Não foi possivel achar uma diaria inferior a essa!"));
	}
	
	public Carro anoEntre(int anoIni, int anoFim) throws ObjectNotFoundException {
		Optional<Carro> carro = carroRepository.findByAnoBetween(anoIni, anoFim);
		return carro.orElseThrow(() -> 
				new ObjectNotFoundException("Não foi encontrado carros entre os anos!"));
	}
	
	public Carro insert(Carro carro) {
		carro.setId(null);
		return carroRepository.save(carro);
	}
	
	public Carro update(Carro carro, Integer id) {
		return carroRepository.save(carro);
	}
	
	public void delete(Integer id) throws ObjectNotFoundException {
		this.findByID(id);
		try {
			carroRepository.deleteById(id);
		}catch(DataIntegrityViolationException e){
			throw new DataIntegrityException("Ocorreu um erro de integridade!");
		}
	}

}
