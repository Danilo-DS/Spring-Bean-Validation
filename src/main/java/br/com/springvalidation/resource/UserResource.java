package br.com.springvalidation.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springvalidation.domain.User;
import br.com.springvalidation.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/users")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserResource {
	
	private final UserService service;
	
	@GetMapping
	public ResponseEntity<?> userList() {
		return ResponseEntity.ok(service.list());
	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<?> findUser(@PathVariable Long userId) {
		return ResponseEntity.ok(service.find(userId));
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public User userSave(@Valid @RequestBody User user) {
		return service.save(user);
	}
	
}
