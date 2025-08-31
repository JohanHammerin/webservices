package se.johan.lektion_6.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.johan.lektion_6.model.Student;
import se.johan.lektion_6.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    //Repo goes here
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }


    @PostMapping("/save")
    public ResponseEntity<Student> insertStudentToStudents(@RequestBody Student student) {
        return ResponseEntity.ok(studentRepository.save(student));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setPassword(updatedStudent.getPassword());
                    student.setEnabled(updatedStudent.getEnabled());
                    studentRepository.save(student);
                    return ResponseEntity.ok(student);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearDatabase() {
        studentRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }


/* INSTRUCTIONS
Skapa en Put Mapping
Skapa felhantering för om ID’t, användarnamn,
Lösenord inte existerar!
Här är det viktigt att en visar upp rätt
meddelanden som också är beskrivande men samt
med så lite/tydlig kod som möjligt.
*/
}
