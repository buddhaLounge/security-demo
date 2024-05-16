package io.getarrays.api.resource;

import java.net.URI;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

public interface BaseResource {

	default URI getLocation(int id) {
		return fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
	}
}
