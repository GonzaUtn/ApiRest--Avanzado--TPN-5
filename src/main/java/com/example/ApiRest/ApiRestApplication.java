package com.example.ApiRest;

import com.example.ApiRest.Controller.PersonaController;
import com.example.ApiRest.Entities.*;
import com.example.ApiRest.Repository.*;
import com.example.ApiRest.Service.PersonaService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;



@SpringBootApplication
public class  ApiRestApplication {
	private static final Logger logger = LoggerFactory.getLogger(ApiRestApplication.class);

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private DomicilioRepository domicilioRepository;
	@Autowired
	private LocalidadRepository localidadRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository , AutorRepository autorRepository , LibroRepository libroRepository,
	LocalidadRepository localidadRepository, DomicilioRepository domicilioRepository) {
		return args -> {

			// Crear instancias de Localidad
			Localidad localidad1 = Localidad.builder().denominacion("Godoy Cruz").build();
			Localidad localidad2 = Localidad.builder().denominacion("Las Heras").build();
			Localidad localidad3 = Localidad.builder().denominacion("Capital").build();
			Localidad localidad4 = Localidad.builder().denominacion("Guaymallen").build();
			localidadRepository.save(localidad1);
			localidadRepository.save(localidad2);
			localidadRepository.save(localidad3);
			localidadRepository.save(localidad4);

			Autor autor1 = Autor.builder().nombre("Gabriel").apellido("Rolon").biografia("Escribe acerca de la autosuperacion").build();
			Libro libro1 = Libro.builder().titulo("El duelo").genero("AutoSuperacion").fecha(21).paginas(85).build();
			autor1.addLibros(libro1);

			Autor autor2 = Autor.builder().nombre("Isabel").apellido("Allende").biografia("Escritora chilena").build();
			Libro libro2 = Libro.builder().titulo("La casa de los espíritus").genero("Ficción").fecha(1982).paginas(433).build();
			autor2.addLibros(libro2);

			Autor autor3 = Autor.builder().nombre("Stephen").apellido("King").biografia("Escritor de horror y suspenso").build();
			Libro libro3 = Libro.builder().titulo("It").genero("Horror").fecha(1986).paginas(1138).build();
			autor3.addLibros(libro3);

			Autor autor4 = Autor.builder().nombre("George").apellido("Orwell").biografia("Escritor y periodista inglés").build();
			Libro libro4 = Libro.builder().titulo("1984").genero("Distopía").fecha(1949).paginas(328).build();
			autor4.addLibros(libro4);

			autorRepository.saveAll(Arrays.asList(autor1, autor2, autor3, autor4));

			// Crear domicilio y persona
			Domicilio dom1 = Domicilio.builder().calle("Adolfo Calle").numero(7653).localidad(localidad1).build();
			Persona persona1 = Persona.builder().nombre("Gonzalo").apellido("Moyano").domicilio(dom1).build();

			Domicilio dom2 = Domicilio.builder().calle("San Martín").numero(2020).localidad(localidad2).build();
			Persona persona2 = Persona.builder().nombre("Lucía").apellido("Pérez").domicilio(dom2).build();

			Domicilio dom3 = Domicilio.builder().calle("Belgrano").numero(1234).localidad(localidad3).build();
			Persona persona3 = Persona.builder().nombre("Carlos").apellido("Gómez").domicilio(dom3).build();

			Domicilio dom4 = Domicilio.builder().calle("Las Heras").numero(7890).localidad(localidad4).build();
			Persona persona4 = Persona.builder().nombre("Ana").apellido("Sánchez").domicilio(dom4).build();

			// Guardar personas
			personaRepository.saveAll(Arrays.asList(persona1, persona2, persona3, persona4));




		};
	}
}