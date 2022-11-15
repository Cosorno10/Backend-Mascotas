package petmascotas.Customerservice.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserDto {
    private Long id;
    private String name;
    private String lastname;
    private int profile;
    private int status = 0;
    private Long phone;
    private String username;
    private String password;

}