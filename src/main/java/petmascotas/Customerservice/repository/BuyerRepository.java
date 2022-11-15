package petmascotas.Customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import petmascotas.Customerservice.model.entity.Buyer;

public interface BuyerRepository extends CrudRepository<Buyer, Integer>, JpaRepository<Buyer, Integer> {

    public Buyer findByDni(String dni);
}
