package petmascotas.Customerservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BuyerDto {

    private Integer id;
    private String name;
    private String lastname;
    private int phone;
    private String dni;
    private String email;
    private String address;
    private String location;

}