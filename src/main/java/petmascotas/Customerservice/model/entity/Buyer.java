package petmascotas.Customerservice.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    private int phone;

    @NotNull
    private String dni;

    @NotNull
    private String address;

    @NotNull
    private String location;

    @NotNull
    private String email;

    @NotNull
    private int status = 0;

        @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;


}
