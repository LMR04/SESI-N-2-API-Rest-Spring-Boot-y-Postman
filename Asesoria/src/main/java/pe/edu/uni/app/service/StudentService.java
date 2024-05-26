package pe.edu.uni.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import pe.edu.uni.app.dto.StudentDto;

@Service
public class StudentService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Map<String, Object>> getAllStudents() {
		String sql = "SELECT id, name, lastname, email, semester " +
					 "FROM Estudiante";
		return jdbcTemplate.queryForList(sql);
	}
	
	public boolean postStudent(StudentDto dto) {
		try {
			String sql = "INSERT INTO Estudiante (name, lastname, email, semester) " +
						 "VALUES(?, ?, ?, ?)";
			jdbcTemplate.update(sql, dto.getName(), dto.getLastname(), dto.getEmail(), dto.getSemester());
			return true;
		} catch(Exception err) {
			return false;			
		}
	}
	
	public Map<String, Object> getStudentById(Integer id) {
		String sql = "SELECT name, lastname, email, semester " +
					 "FROM Estudiante " +
					 "WHERE id = ?";
		return jdbcTemplate.queryForMap(sql, id);
	}
	
	public List<Map<String, Object>> getStudentsBySemester(Integer semester) {
		String sql = "SELECT id, name, lastname, email " +
					 "FROM Estudiante " +
					 "WHERE semester = ?";
		return jdbcTemplate.queryForList(sql, semester);
	}
	
	public boolean deleteStudent(Integer id) {
		try {
			String sql = "DELETE FROM Estudiante " +
						 "WHERE id = ?";
			jdbcTemplate.update(sql, id);
			return true;
		} catch(Exception err) {
			return false;			
		}
	}
	
	public boolean updateStudent(Integer id, StudentDto dto) {
		try {
			String sql = "UPDATE Estudiante SET name = ?, lastname = ?, email = ?, semester = ? " +
						 "WHERE id = ?";
			jdbcTemplate.update(sql, dto.getName(), dto.getLastname(), dto.getEmail(), dto.getSemester(), id);
			return true;
		} catch(Exception err) {
			return false;			
		}
	}
}
