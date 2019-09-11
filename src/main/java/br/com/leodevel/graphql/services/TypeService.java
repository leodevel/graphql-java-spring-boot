package br.com.leodevel.graphql.services;

import br.com.leodevel.graphql.model.Type;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@GraphQLApi
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @GraphQLMutation(name = "addType")
    public Type addType(@GraphQLArgument(name = "name") String name) throws Exception {
        Type type = new Type(name);        
        typeRepository.save(type);
        return type;
    }
    
    @GraphQLQuery(name = "getTypes")
    public List<Type> getTypes(){        
        return typeRepository.findAll();        
    }    

}