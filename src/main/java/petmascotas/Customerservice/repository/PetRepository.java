package petmascotas.Customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import petmascotas.Customerservice.model.entity.Pet;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long>, JpaRepository<Pet, Long> {

    public List<Pet> findByType(String type);
    public List<Pet> findByTypeAndStatus(String type, int status);
    public List<Pet> findByStatus(int status);

}
