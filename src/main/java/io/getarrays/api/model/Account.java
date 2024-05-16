package io.getarrays.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class Account implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true, nullable = false)
	@NotNull
	private String username;

	@Column(nullable = false)
	@NotNull
	private String password;
	private boolean enabled = true;
	private boolean credentialsExpired = false;
	private boolean expired = false;
	private boolean locked = false;

	@ManyToMany(fetch = EAGER)
	@JoinTable(
		name = "USERS_ROLES",
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
	)
	private List<Role> roles;

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Account{");
		sb.append("id=").append(id);
		sb.append(", username='").append(username).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", enabled=").append(enabled);
		sb.append(", credentialsExpired=").append(credentialsExpired);
		sb.append(", expired=").append(expired);
		sb.append(", locked=").append(locked);
		sb.append(", roles=").append(roles);
		sb.append('}');
		return sb.toString();
	}
}
