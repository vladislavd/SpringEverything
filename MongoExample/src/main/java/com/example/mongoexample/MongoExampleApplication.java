package com.example.mongoexample;

import com.example.mongoexample.model.Address;
import com.example.mongoexample.model.Gender;
import com.example.mongoexample.model.Student;
import com.example.mongoexample.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongoExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongoExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository, MongoTemplate template) {
        String email = "ali1@mail.ru";
        return args -> {
            Student student = new Student(
                    "Ali",
                    "Baba",
                    email,
                    Gender.MALE,
                    new Address("Country1", "CityOne", "POSTCODE1"),
                    List.of("Subject1", "Subject2"),
                    BigDecimal.valueOf(1L),
                    LocalDateTime.now()
            );
            usingMongoTemplate(repository, template, email, student);
            repository.findByEmail(email)
                    .ifPresentOrElse(
                            s -> System.out.println("s = " + s),
                            () -> repository.insert(student));

            System.out.println("repository.findStudentsWithGender() = " + repository.findStudentsWithGender());
            System.out.println("repository.findStudentsWithoutGender() = " + repository.findStudentsWithoutGender());
        };

    }

    private static void usingMongoTemplate(StudentRepository repository, MongoTemplate template, String email, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        List<Student> students = template.find(query, Student.class);

        System.out.println("students = " + students);

        if (students.isEmpty()) {
            repository.insert(student);
        }
    }
}
