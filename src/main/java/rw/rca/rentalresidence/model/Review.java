package rw.rca.rentalresidence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@Document(collection = "reviews")
public class Review {
   @Id
   @JsonValue(value = true)
   @JsonProperty(access = JsonProperty.Access.READ_ONLY)
   private String id;

   private Integer rating;
   private String description;

   @DBRef
   private User user;

   @DBRef
   private Property property;

   // getters and setters

   public void setDescription(String description) {
       this.description = description;
   }

   public void setId(String id) {
       this.id = id;
   }

    public void setProperty(Property property) {
         this.property = property;
    }

    public void setRating(Integer rating) {
         this.rating = rating;
    }

    public void setUser(User user) {
         this.user = user;
    }

    public String getDescription() {
         return description;
    }

    public String getId() {
         return id;
    }

    public Property getProperty() {
         return property;
    }

    public Integer getRating() {
         return rating;
    }

    public User getUser() {
         return user;
    }
}
