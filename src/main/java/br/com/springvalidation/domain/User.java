package br.com.springvalidation.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import br.com.springvalidation.validation.UserValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TB_USER")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable{
	
	private static final long serialVersionUID = -7251790374086584319L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(groups = UserValidation.class)
	@Column(name = "COD")
	private Long id;
	
	@Column(name = "USERNAME")
	@NotBlank(message = "Field Name can't blank")
	private String name;
	
	@Column(name = "EMAIL")
	@NotBlank(message = "Field Email can't blank")
	@Email(message = "It is not a valid email")
	private String email;
	
	@Column(name = "NU_CPF")
	@Size(max = 11, min = 11, message = "Maximum and minimum size is 11 characters")
	private String cpf;
	
	
}
