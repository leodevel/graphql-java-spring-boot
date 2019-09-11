package br.com.leodevel.graphql.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    
    // fields    
    @Id
    private ObjectId id;        
    private String name;
    private String email;
    private String login;
    private String password;    
    private String idType;

    public User(String name, String email, String login, String password, String idType) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;        
        this.idType = idType;
    }       
    
    public User() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
    @GraphQLQuery(name = "id_user", description = "Id do usuário")
    public String getIdUser() {
        return id == null ? null : id.toString();
    }

    public void setIdUser(ObjectId id) {
        this.id = id;
    }

    @GraphQLQuery(name = "name", description = "Nome do usuário")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    @GraphQLQuery(name = "email", description = "Email do usuário")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @GraphQLQuery(name = "login", description = "Login do usuário")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @GraphQLIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @GraphQLIgnore
    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }    
    
}