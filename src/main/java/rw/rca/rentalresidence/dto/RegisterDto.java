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
public class RegisterDto {
    @ApiModelProperty(notes = "Full names", example = "Mark Bernard", required = true)
    private String names;

    @ApiModelProperty(notes = "Email", example = "bernard@gmail.com", required = true)
    private String email;

    @ApiModelProperty(notes = "Phone", example = "+250781234567", required = false)
    private String phoneNumber;

    @ApiModelProperty(notes = "Password", example = "#Password123", required = true)
    private String password;

public Object getName() {
        return null;
}
}
