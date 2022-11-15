package petmascotas.Customerservice.model.mapper;

import org.mapstruct.Mapper;
import petmascotas.Customerservice.model.dto.PetDto;
import petmascotas.Customerservice.model.entity.Pet;

@Mapper(componentModel = "spring")
public interface PetMapper {
    Pet toEntity(PetDto petDto);

    /*@Mappings({
            @Mapping(source = "idClient", target = "id"),
            @Mapping(source = "nombre", target = "name")
    })*/
    PetDto toDto(Pet pet);
}