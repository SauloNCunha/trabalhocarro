package br.com.trabalhocarro.teste;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.trabalhocarro.domain.Carro;
import br.com.trabalhocarro.domain.Modelo;
import br.com.trabalhocarro.repositories.CarroRepository;
import br.com.trabalhocarro.repositories.ModeloRepository;

@SpringBootApplication
public class CarrosAplication implements CommandLineRunner{

	@Autowired
	private ModeloRepository modeloRepository;
	
	@Autowired
	private CarroRepository carroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CarrosAplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		Modelo m1 = new Modelo(1,"Esportivo");
		Modelo m2 = new Modelo(2,"Sedam");
		Modelo m3 = new Modelo(3,"Off-Road");
		Modelo m4 = new Modelo(4,"Cupe");
		Modelo m5 = new Modelo(5,"SUV");
		modeloRepository.saveAll(Arrays.asList(m1,m2,m3,m4,m5));
		
		Carro c1 = new Carro(1,2005,1876.5,50.5,"cinza", m1);
		Carro c2 = new Carro(2,2008,113468.5,5140.5,"preto", m3);
		Carro c3 = new Carro(3,2010,11762.5,550.5,"branco", m4);
		Carro c4 = new Carro(4,2018,113578.5,565.5,"azul", m5);
		Carro c5 = new Carro(5,2019,1146.5,5617.1,"marom", m2);
		Carro c6 = new Carro(6,2020,114134.5,1517.3,"verde", m3);
		Carro c7 = new Carro(7,2007,15146.5,5145,"preto", m1);
		Carro c8 = new Carro(8,2009,1271156.5,540.5,"branco", m2);
		Carro c9 = new Carro(9,2016,1613.5,100.5,"roxo", m4);
		Carro c10 = new Carro(10,2011,1514.5,25.5,"branco", m5);
		carroRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10));
	}
	

}
