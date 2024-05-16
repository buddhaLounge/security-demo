package io.getarrays.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEES")
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	@NotNull
	private String firstName;

	@Column(nullable = false)
	@NotNull
	private String lastName;

	@Column(nullable = false)
	@NotNull
	private String email;

}
