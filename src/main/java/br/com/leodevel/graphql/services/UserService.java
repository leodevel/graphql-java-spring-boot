package br.com.leodevel.graphql.services;

import br.com.leodevel.graphql.model.Type;
import br.com.leodevel.graphql.model.User;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@GraphQLApi
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TypeRepository typeRepository;

    @GraphQLMutation(name = "addUser")
    public User addUser(@GraphQLArgument(name = "name") String name,
            @GraphQLArgument(name = "email") String email,
            @GraphQLArgument(name = "login") String login,
            @GraphQLArgument(name = "password") String password,
            @GraphQLArgument(name = "id_type") String idType) {
        User user = new User(name, email, login, password, idType);
        userRepository.save(user);
        return user;
    }
    
    @GraphQLMutation(name = "removeUserByEmail")
    public boolean removeUserByEmail(@GraphQLArgument(name = "email") String email) {        
        userRepository.delete(userRepository.findByEmail(email));
        return true;
    }

    @GraphQLQuery(name = "getUsers")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GraphQLQuery(name = "getUserByEmail")
    public User getUsers(@GraphQLArgument(name = "email") String email) {
        return userRepository.findByEmail(email);
    }

    @GraphQLQuery(name = "type")
    public Type getType(@GraphQLContext User user) {
        return typeRepository.findById(user.getIdType()).get();
    }

}
