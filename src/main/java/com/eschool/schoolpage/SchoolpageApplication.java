package com.eschool.schoolpage;

import com.eschool.schoolpage.models.*;
import com.eschool.schoolpage.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class SchoolpageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolpageApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UsuarioRepository usuarioRepository, MateriaRepository materiaRepository, ContenidoRepository contenidoRepository,
									  UsuarioMateriaRepository usuarioMateriaRepository, ComentarioRepository comentarioRepository,
									  RespuestaRepository respuestaRepository) {
		return (args) -> {

			//-------------------------------------USUARIOS-------------------------------------------------
			Usuario luis = new Usuario("Luis", "Ibañez", "94706338", "luis@gmail.com", "1234", Rol.ESTUDIANTE);
			Usuario tony = new Usuario("Tony", "Stark", "94706338", "tony@gmail.com", "1234", Rol.ESTUDIANTE);
			usuarioRepository.save(luis);
			usuarioRepository.save(tony);


			Usuario antonio = new Usuario("Antonio", "Rigan", "94706338", "antoniorigan@gmail.com", "1234", Rol.PROFESOR);
			usuarioRepository.save(antonio);
			//--------------------------------------------------------------------------------------

			//-------------------------------------Materias-------------------------------------------------
			Materia matematica = new Materia("Matematica", "Polinomios, Diferenciales, Trigonometria", "https://cdn-blog.superprof.com/blog_co/wp-content/uploads/2020/10/las-matematicas.jpeg" );
			Materia quimica = new Materia("Quimica", "Gases, Estados, Composicion Atómica", "https://cards.algoreducation.com/_next/image?url=https%3A%2F%2Ffiles.algoreducation.com%2Fproduction-ts%2F__S3__85d3dd80-4e5e-4469-961c-a4b3a1814e27&w=3840&q=75");
			materiaRepository.save(matematica);
			materiaRepository.save(quimica);
			//--------------------------------------------------------------------------------------



			//-------------------------------------Agrego contenido a las materias-------------------------------------------------
			Contenido contenido1Matematica = new Contenido("Parabolas", LocalDateTime.now(), "Hablamos sobre como calcular las parabolas", "https://drive.google.com/file/d/1JZbeO-zW9rraskFvcyyWDiNMyBkoVlBz/view?usp=drive_link");
			Contenido contenido2Matematica = new Contenido("Polinomios", LocalDateTime.now(), "Calculo de polinomios de 1er a 3er grado", "https://drive.google.com/file/d/1JZbeO-zW9rraskFvcyyWDiNMyBkoVlBz/view?usp=drive_link");

			matematica.addContenido(contenido1Matematica);
			matematica.addContenido(contenido2Matematica);
			contenidoRepository.save(contenido1Matematica);
			contenidoRepository.save(contenido2Matematica);


			Contenido contenido1Quimica = new Contenido("Gases", LocalDateTime.now(), "Hablamos sobre los tipos de gases", "https://drive.google.com/file/d/1JZbeO-zW9rraskFvcyyWDiNMyBkoVlBz/view?usp=drive_link");
			Contenido contenido2Quimica = new Contenido("Estados", LocalDateTime.now(), "Hablamos sobre los distitos estados de la materia", "https://drive.google.com/file/d/1JZbeO-zW9rraskFvcyyWDiNMyBkoVlBz/view?usp=drive_link");

			quimica.addContenido(contenido1Quimica);
			quimica.addContenido(contenido2Quimica);
			contenidoRepository.save(contenido1Quimica);
			contenidoRepository.save(contenido2Quimica);
			//--------------------------------------------------------------------------------------


			//-------------------------------------Agrego comentarios a los contenidos-------------------------------------------------
			Comentario comentario1MatematicaContenido1 = new Comentario("No me quedo claro el calculo de los parabolas...", LocalDateTime.now());
			contenido1Matematica.addComentario(comentario1MatematicaContenido1);
			comentario1MatematicaContenido1.setContenido(contenido1Matematica);
			comentarioRepository.save(comentario1MatematicaContenido1);


			Comentario comentario1MatematicaContenido2 = new Comentario("No me quedo claro el calculo de los polinomios...", LocalDateTime.now());
			contenido2Matematica.addComentario(comentario1MatematicaContenido2);
			comentario1MatematicaContenido2.setContenido(contenido2Matematica);
			comentarioRepository.save(comentario1MatematicaContenido2);


			Comentario comentario1QuimicaContenido1 = new Comentario("No me quedo claro el tema de los gases...", LocalDateTime.now());
			contenido1Quimica.addComentario(comentario1QuimicaContenido1);
			comentario1QuimicaContenido1.setContenido(contenido1Quimica);
			comentarioRepository.save(comentario1QuimicaContenido1);

			Comentario comentario1QuimicaContenido2 = new Comentario("No me quedo claro el tema de los ESTADOS...", LocalDateTime.now());
			contenido2Quimica.addComentario(comentario1QuimicaContenido2);
			comentario1QuimicaContenido2.setContenido(contenido2Quimica);
			comentarioRepository.save(comentario1QuimicaContenido2);
			//--------------------------------------------------------------------------------------


			//-------------------------------------Agrego respuestas a los comentarios-------------------------------------------------
			Respuesta respuesta1Comentario1QuimicaContenido1 = new Respuesta("Te explico, cuando tienes...", LocalDateTime.now());
			comentario1QuimicaContenido1.addRespuesta(respuesta1Comentario1QuimicaContenido1);
			respuesta1Comentario1QuimicaContenido1.setComentario(comentario1QuimicaContenido1);
			respuestaRepository.save(respuesta1Comentario1QuimicaContenido1);


			Respuesta respuesta1Comentario1MatematicaContenido2 = new Respuesta("Para llegar a la respuesta debes...", LocalDateTime.now());
			comentario1MatematicaContenido2.addRespuesta(respuesta1Comentario1MatematicaContenido2);
			respuesta1Comentario1MatematicaContenido2.setComentario(comentario1MatematicaContenido2);
			respuestaRepository.save(respuesta1Comentario1MatematicaContenido2);
			//--------------------------------------------------------------------------------------







			//-------------------------------------Asocio las materias con los usuarios-------------------------------------------------
			UsuarioMateria luisMateria1 = new UsuarioMateria(JornadaTurno.MORNIG);
			luis.addUsuarioMateria(luisMateria1);
			matematica.addUsuarioMateria(luisMateria1);
			usuarioMateriaRepository.save(luisMateria1);

			UsuarioMateria luisMateria2 = new UsuarioMateria(JornadaTurno.EVENING);
			quimica.addUsuarioMateria(luisMateria2);
			luis.addUsuarioMateria(luisMateria2);
			usuarioMateriaRepository.save(luisMateria2);


			UsuarioMateria tonyMateria1 = new UsuarioMateria(JornadaTurno.MORNIG);
			quimica.addUsuarioMateria(tonyMateria1);
			tony.addUsuarioMateria(tonyMateria1);
			usuarioMateriaRepository.save(tonyMateria1);

			UsuarioMateria tonyMateria2 = new UsuarioMateria(JornadaTurno.MORNIG);
			matematica.addUsuarioMateria(tonyMateria2);
			tony.addUsuarioMateria(tonyMateria2);
			usuarioMateriaRepository.save(tonyMateria2);

			UsuarioMateria antonioPrefesor = new UsuarioMateria(JornadaTurno.MORNIG);
			matematica.addUsuarioMateria(antonioPrefesor);
			antonio.addUsuarioMateria(antonioPrefesor);
			usuarioMateriaRepository.save(antonioPrefesor);
			//--------------------------------------------------------------------------------------


		};
	}

}
