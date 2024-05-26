package pe.edu.uni.app.repository;

import pe.edu.uni.app.model.StudentModel;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Long> {
	public abstract ArrayList<StudentModel> findBySemester(Integer semester);
}
