package br.com.springvalidation.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import br.com.springvalidation.validation.UserValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "TB_EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Employee implements Serializable {
	
	private static final long serialVersionUID = -3980753011721415967L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD")
	private Long id;
	
	@NotBlank(message = "Field Name can't blank")
	@Column(name = "NM_EMPLOYEE")
	private String name;
	
	@Valid
	@ConvertGroup(from = Default.class, to = UserValidation.class )
	@NotNull(message = "It is necessary to inform a user")
	@OneToOne
	private User user;
	
	@NotBlank(message = "Field Registry can't blank")
	@Column(name = "NU_REGISTRATION")
	private String registry;

}
