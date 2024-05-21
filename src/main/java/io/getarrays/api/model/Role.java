package io.getarrays.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.getarrays.api.model.constants.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ROLES")
@NoArgsConstructor
public class Role implements Serializable {

	public Role(int id, String code, RoleType name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String code;

	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private RoleType name;

	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private List<Account> users;

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Role{");
		sb.append("id=").append(id);
		sb.append(", code='").append(code).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
