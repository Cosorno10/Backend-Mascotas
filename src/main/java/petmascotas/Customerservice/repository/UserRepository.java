package petmascotas.Customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import petmascotas.Customerservice.model.entity.User;

public interface UserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long> {

    public User findByUsername(String username);
}
