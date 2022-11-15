package petmascotas.Customerservice.model.mapper;

import org.mapstruct.Mapper;
import petmascotas.Customerservice.model.dto.BuyerDto;
import petmascotas.Customerservice.model.entity.Buyer;

@Mapper(componentModel = "spring")
public interface CustomerMap {
    Buyer toEntity(BuyerDto buyerDto);

    /*@Mappings({
            @Mapping(source = "idClient", target = "id"),
            @Mapping(source = "nombre", target = "name")
    })*/
    BuyerDto toDto(Buyer buyer);
}