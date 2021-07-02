package br.com.springvalidation.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.springvalidation.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
