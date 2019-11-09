package br.com.trabalhocarro.teste;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		SpringApplication.run(CarrosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		Modelo m1 = new Modelo(1,"Modelo esportivo");
		Modelo m2 = new Modelo(2,"Modelo sedam");
		Modelo m3 = new Modelo(3,"Modelo off-road");
		Modelo m4 = new Modelo(4,"Modelo amfibio");
		Modelo m5 = new Modelo(5,"Modelo Tesla");
		modeloRepository.saveAll(Arrays.asList(m1,m2,m3,m4,m5));
		
		Carros c1 = new Carros(1,2005,1876.5,50.5,"preto", m1);
		Carros c2 = new Carros(2,2008,113468.5,5140.5,"preto", m3);
		Carros c3 = new Carros(3,2010,11762.5,550.5,"preto", m4);
		Carros c4 = new Carros(4,2018,113578.5,565.5,"preto", m5);
		Carros c5 = new Carros(5,2019,1146.5,5617.1,"preto", m2);
		Carros c6 = new Carros(6,2020,114134.5,1517.3,"preto", m3);
		Carros c7 = new Carros(7,2007,15146.5,5145,"preto", m1);
		Carros c8 = new Carros(8,2009,1271156.5,540.5,"preto", m2);
		Carros c9 = new Carros(9,2016,1613.5,100.5,"preto", m4);
		Carros c10 = new Carros(10,2011,1514.5,25.5,"preto", m5);
		carroRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10));
	}
	

}
