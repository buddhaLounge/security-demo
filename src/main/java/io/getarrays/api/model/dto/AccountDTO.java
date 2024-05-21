package io.getarrays.api.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class AccountDTO {

	@NotNull
	private String username;

	@NotNull
	private String password;

	@NotNull
	@Email
	private String email;

	@Valid
	private List<RoleDTO> roles = new ArrayList<>();

}
