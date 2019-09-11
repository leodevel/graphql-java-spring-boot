package br.com.leodevel.graphql.services;

import br.com.leodevel.graphql.model.Type;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeRepository extends MongoRepository<Type, String> {     
    
}
