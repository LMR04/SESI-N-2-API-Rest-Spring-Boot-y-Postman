package pe.edu.uni.app.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.app.model.StudentModel;
import pe.edu.uni.app.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping()
	public ArrayList<StudentModel> getStudents(){
		return studentService.getStudents();
	}
	
	@PostMapping()
	public StudentModel postStudent(@RequestBody StudentModel student) {
		return this.studentService.postStudent(student);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<StudentModel> getStudentById(@PathVariable("id") Long id){
		return this.studentService.getStudentById(id);
	}
	
	@GetMapping("/query")
	public ArrayList<StudentModel> getStudentsBySemester(@RequestParam("semester") Integer semester){
		return this.studentService.getStudentsBySemester(semester);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteStudent(@PathVariable("id") Long id){
		boolean Ok = this.studentService.deleteStudent(id);
		if (Ok) {
			return "Fue eliminado el estudiante " + id;
		} else {
			return "No se pudo eliminar al estudiante " + id;
		}
	}
	
}
