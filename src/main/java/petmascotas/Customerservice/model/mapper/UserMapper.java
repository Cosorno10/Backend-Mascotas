package petmascotas.Customerservice.model.mapper;

import org.mapstruct.Mapper;
import petmascotas.Customerservice.model.dto.UserDto;
import petmascotas.Customerservice.model.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto userDto);

    /*@Mappings({
            @Mapping(source = "idClient", target = "id"),
            @Mapping(source = "nombre", target = "name")
    })*/

    UserDto toDto(User user);
}
