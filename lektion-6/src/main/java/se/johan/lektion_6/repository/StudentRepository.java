package se.johan.lektion_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.johan.lektion_6.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


    List<Student> findByName(String name);

    Student findStudentByNameAndPassword(String name, String password);
}
