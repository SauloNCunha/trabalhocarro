package br.com.trabalhocarro.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.trabalhocarro.domain.Carro;
import br.com.trabalhocarro.service.CarroService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="Carro")
public class CarroResources {
	
	
	@Autowired
	private CarroService carroService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Carro>> findAll(){
		List<Carro> carros = carroService.findAll();
		return ResponseEntity.ok().body(carros);
	}
	
	@RequestMapping(value="/odometro", method=RequestMethod.GET)
	public ResponseEntity<Carro> kmSuperior(@RequestParam (value="odometro")double km) throws ObjectNotFoundException{
		Carro carro = carroService.kmSuperior(km);
		return ResponseEntity.ok().body(carro);
	}
	
	@RequestMapping(value="/diaria", method=RequestMethod.GET)
	public ResponseEntity<Carro> diariainferior(@RequestParam (value="diaria")double diaria) throws ObjectNotFoundException{
		Carro carro = carroService.diariaInferior(diaria);
		return ResponseEntity.ok().body(carro);
	}
	
	@RequestMapping(value="ano", method=RequestMethod.GET)
	public ResponseEntity<Carro> anoEntre(@RequestParam (value="ano")int anoIni, int anoFim) throws ObjectNotFoundException{
		Carro carro = carroService.anoEntre(anoIni, anoFim);
		return ResponseEntity.ok().body(carro);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Carro> insert(@RequestBody Carro carro){
		carro = carroService.insert(carro);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/id/{id}")
				.buildAndExpand(carro.getId())
				.toUri();
		return ResponseEntity.created(uri).body(carro);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="id/{id}")
	public ResponseEntity<Void> update(@RequestBody Carro carro, @PathVariable Integer id){
		carro.setId(id);
		carro = carroService.update(carro, id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/id/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException{
		carroService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
