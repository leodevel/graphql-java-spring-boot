package br.com.leodevel.graphql.services;

import br.com.leodevel.graphql.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
 
    User findByEmail(String email);    
    
}
