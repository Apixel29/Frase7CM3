package com.ipn.mx.frases;

import com.ipn.mx.frases.domain.entities.Frase;
import com.ipn.mx.frases.domain.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrasesApplication implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
//        Frase f =  new Frase();
//        f.setId(3L); //Es autonumerica, se quita para insertar a la base de datos
//        f.setAutor("Uzumaki Naruto");
//        f.setTexto("No vivas con falsedades ni miedos, porque terminaras odiandote a ti mismo");

//        dao.save(f); //Insertar a la base}
//        IO.println(dao.findById(1L));
//        IO.println(dao.findAll());
//        dao.deleteById(f.getId());

//        System.out.println(f);

//        Frase f2 =  Frase.builder()
//                .id(2L)
//                .texto("Ya me quiero ir")
//                .autor("yo")
//                .build();

//        IO.println(f2);
    }

    public static void main(String[] args) {SpringApplication.run(FrasesApplication.class, args);}
}
