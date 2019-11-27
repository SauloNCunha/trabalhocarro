package br.com.trabalhocarro.resources;

import br.com.trabalhocarro.exception.DataIntegrityException;
import br.com.trabalhocarro.exception.ObjectNotFoundException;
import br.com.trabalhocarro.repositories.ModeloRepository;

import java.util.List;
import java.util.Optional;
import br.com.trabalhocarro.domain.Modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ModeloService {

	@Autowired
	private ModeloRepository modeloRepository;
	
	public List<Modelo> findAll(){
		return modeloRepository.findAll();
	}
	
	public Modelo findById(Integer id) {
		Optional<Modelo> modelo = modeloRepository.findById(id);
		return modelo.orElseThrow(() ->
				new ObjectNotFoundException("Modelo não encontrado!"));
	}
	
	public Modelo findByDescricao(String descricao) {
		Optional<Modelo> modelo = modeloRepository.findByDescricao(descricao);
		return modelo.orElseThrow(() ->
				new ObjectNotFoundException("Descrição não encontrada!"));
	}
	
	public Modelo insert (Modelo modelo) {
		modelo.setId(null);
		return modeloRepository.save(modelo);
	}
	
	public Modelo update(Modelo modelo, Integer id) {
		return modeloRepository.save(modelo);
	}
	
	public void delete(Integer id) {
		this.findById(id);
		try {
			modeloRepository.deleteById(id);
			
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Ocorreu um erro de integridade!");
		}
	}
}
