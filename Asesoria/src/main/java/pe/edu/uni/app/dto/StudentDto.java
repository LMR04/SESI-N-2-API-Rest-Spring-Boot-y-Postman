package pe.edu.uni.app.dto;

import lombok.Data;

@Data
public class StudentDto {
	private Integer id;
	private String name;
	private String lastname;
	private String email;
	private Integer semester;
}
