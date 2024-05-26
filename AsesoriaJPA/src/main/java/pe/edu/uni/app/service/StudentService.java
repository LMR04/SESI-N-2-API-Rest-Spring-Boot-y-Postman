package pe.edu.uni.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.uni.app.model.StudentModel;
import pe.edu.uni.app.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public ArrayList<StudentModel> getStudents(){
		return (ArrayList<StudentModel>) studentRepository.findAll();
	}
	
	public StudentModel postStudent(StudentModel student) {
		return studentRepository.save(student);
	}
	
	public Optional<StudentModel> getStudentById(Long id) {
		return studentRepository.findById(id);
	}
	
	public ArrayList<StudentModel> getStudentsBySemester(Integer semester){
		return (ArrayList<StudentModel>) studentRepository.findBySemester(semester);
	}
	
	public boolean deleteStudent(Long id) {
		try {
			studentRepository.deleteById(id);
			return true;
		} catch(Exception err) {
			return false;
		}
	}
	
}
