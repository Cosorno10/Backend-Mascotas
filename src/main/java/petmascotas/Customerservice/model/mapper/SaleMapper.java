package petmascotas.Customerservice.model.mapper;

import org.mapstruct.Mapper;
import petmascotas.Customerservice.model.dto.SaleDto;
import petmascotas.Customerservice.model.entity.Sale;

@Mapper(componentModel = "spring")
public interface SaleMapper {

    Sale toEntity(SaleDto saleDto);
    /*@Mappings({
            @Mapping(source = "idClient", target = "id"),
            @Mapping(source = "nombre", target = "name")
    })*/

    SaleDto toDto(Sale sale);
}
