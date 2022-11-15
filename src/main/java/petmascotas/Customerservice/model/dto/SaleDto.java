package petmascotas.Customerservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SaleDto {
    private Long id;
    private Long pet_id;
    private Long buyer_id;
    private Long user_id;
}
