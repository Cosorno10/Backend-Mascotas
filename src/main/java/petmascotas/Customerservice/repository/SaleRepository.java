package petmascotas.Customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import petmascotas.Customerservice.model.entity.Sale;
import petmascotas.Customerservice.model.entity.SaleReport;

import java.util.List;

public interface SaleRepository extends CrudRepository<Sale, Long>, JpaRepository<Sale, Long> {
    @Query(
            value = "SELECT\n" +
                    "    \tCONCAT(u.name, ' ', u.lastname) as nameUser,\n" +
                    "    u.username,\n" +
                    "    \tu.phone as phoneUser,\n" +
                    "    \tCONCAT(b.name, ' ', b.lastname) as nameBuyer,\n" +
                    "    \tb.phone as phoneBuyer,\n" +
                    "    b.email as emailBuyer,\n" +
                    "    b.location as locationBuyer,\n" +
                    "    b.dni as dniBuyer,\n" +
                    "    \tp.name as namePet,\n" +
                    "    p.price,\n" +
                    "    \tp.type,\n" +
                    "    DATE_FORMAT(s.created, \"%d %M %Y %H:%i:%S\") as created\n" +
                    "FROM sale s\n" +
                    "INNER JOIN user u ON s.user_id = u.id\n" +
                    "INNER JOIN buyer b ON s.buyer_id = b.id\n" +
                    "INNER JOIN pet p ON s.pet_id = p.id;",
            nativeQuery = true)
    List<SaleReport> findSales();
}
