package pe.edu.uni.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Student")
public class StudentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(unique = true, nullable = false)
	private Long id;
	private String name;
	private String lastname;
	private String email;
	private Integer semester;
}
