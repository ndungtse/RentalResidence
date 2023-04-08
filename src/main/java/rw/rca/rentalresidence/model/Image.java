package rw.rca.rentalresidence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "images")
public class Image {
    @Id
    private String id;

    private String url;
    private String caption;

    @DBRef
    private Property property;

    public Image(String url, String caption, Property property) {
        this.url = url;
        this.caption = caption;
        this.property = property;
    }
}

