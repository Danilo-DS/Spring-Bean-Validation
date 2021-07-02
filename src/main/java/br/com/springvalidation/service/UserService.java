package br.com.springvalidation.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.springvalidation.domain.User;
import br.com.springvalidation.exception.UserException;
import br.com.springvalidation.repositoy.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class UserService {

	private final UserRepository repository;
	
	public List<User> list() {
		return repository.findAll();
	}
	
	public User find(Long userId) {
		return repository.findById(userId).orElseThrow(() -> new UserException("Error User Not Found 404", HttpStatus.NOT_FOUND));
	}
	
	public User save(User user) {
		return repository.save(user);
	}
	
	public User update(Long userId, User user) {
		if(isExistingUser(userId))
			throw new UserException("Sorry! User Not Existing 400", HttpStatus.BAD_REQUEST);
		
		User userUpdated = find(userId);
		BeanUtils.copyProperties(user, userUpdated, "id");
		
		return repository.save(userUpdated);
	}
	
	private boolean isExistingUser(Long id) {
		return repository.existsById(id);
	}
}
