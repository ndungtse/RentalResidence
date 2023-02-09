package rw.rca.rentalresidence.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rw.rca.rentalresidence.model.User;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
//@Schema(description = "Auth Dto schema")
public class AuthResponseDto {
//    @Schema(description = "Response message")
    private String message;
    
//    @Schema(description = "Response token")
    private String token;

    private User user;

    private List<User> users;
}
