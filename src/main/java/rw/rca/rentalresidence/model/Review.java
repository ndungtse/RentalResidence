package rw.rca.rentalresidence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
}
