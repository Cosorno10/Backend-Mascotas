package petmascotas.Customerservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private long pet_id;
    private long buyer_id;
    private long user_id;

    @CreatedDate
    private LocalDateTime created;
}
