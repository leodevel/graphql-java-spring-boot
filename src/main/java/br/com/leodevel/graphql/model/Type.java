package br.com.leodevel.graphql.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "types")
public class Type {
    
    // fields    
    @Id
    private ObjectId id;        
    private String name;    

    public Type(ObjectId id, String name) {
        this.id = id;
        this.name = name;
    }       

    public Type(String name) {
        this.name = name;
    }    
    
    public Type() {
    }

    @GraphQLQuery(name = "id_type", description = "Id do tipo")
    public String getIdType() {
        return id == null ? null : id.toString();        
    }

    public void setIdType(ObjectId idType) {
        this.id = idType;
    }

    @GraphQLQuery(name = "name", description = "Nome do tipo")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
}