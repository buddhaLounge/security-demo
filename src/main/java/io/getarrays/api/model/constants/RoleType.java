package io.getarrays.api.model.constants;

import java.util.Arrays;

public enum RoleType {
	USER, ADMIN;

	public static RoleType getByName(String roleName){
		return Arrays.stream(values()).filter(p -> roleName.equals(p.name())).findFirst().orElseThrow(IllegalArgumentException::new);
	}
}
