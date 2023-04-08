package rw.rca.rentalresidence.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {
        @ApiModelProperty(notes = "Email", example = "bernard@gmail.com", required = true)
        private String email;

        @ApiModelProperty(notes = "Password", example = "#Password123", required = true)
        private String password;
}
