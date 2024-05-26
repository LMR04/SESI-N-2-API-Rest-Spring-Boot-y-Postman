package pe.edu.uni.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.uni.app.dto.StudentDto;
import pe.edu.uni.app.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Map<String, Object>> getStudents(){
		return studentService.getAllStudents();
	}
	
	@PostMapping
	public String postStudent(@RequestBody StudentDto dto) {
		boolean ok = studentService.postStudent(dto);
		if(ok) {
			return "El estudiante " + dto.getName() + " fue agregado";
		} else {
			return "El estudiante " + dto.getName() + " no fue agregado";
		}
	}
	
	@GetMapping("/{id}")
	public Map<String, Object> getStudentById(@PathVariable Integer id){
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/filtro")
	public List<Map<String, Object>> getStudentsBySemester(@RequestParam Integer semester){
		return studentService.getStudentsBySemester(semester);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		boolean ok = studentService.deleteStudent(id);
		if(ok) {
			return "El estudiante " + id + " fue eliminado";
		} else {
			return "El estudiante " + id + " no fue eliminado";
		}
	}
	
	@PutMapping("/{id}")
	public String updateStudent(@PathVariable Integer id, @RequestBody StudentDto dto) {
		boolean ok = studentService.updateStudent(id, dto);
		if(ok) {
			return "El estudiante " + id + " fue actualizado";
		} else {
			return "El estudiante " + id + " no fue actualizado";
		}
	}
}
