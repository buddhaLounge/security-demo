package io.getarrays.api.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;
	
	@NotNull
	@Email
	private String email;

}
