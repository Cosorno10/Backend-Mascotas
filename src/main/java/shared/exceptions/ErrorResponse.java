package shared.exceptions;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private int code;
    private String message;
    private Date timestamp;
    private List<String> errors;
}
