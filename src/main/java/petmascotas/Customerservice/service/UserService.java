package petmascotas.Customerservice.service;

import petmascotas.Customerservice.model.dto.UserDto;

import java.util.List;

public interface UserService {
    //Usuario = Crear, modificar, listar, eliminar(cambiar estado) de él mismo o de otros usuarios

    public UserDto add(UserDto userDto) throws Exception;
    public UserDto modify(UserDto userDtoD) throws Exception;
    public UserDto delete(UserDto userDto) throws Exception;
    public List<UserDto> get() throws Exception;
    public List<UserDto> getByStatus(String status) throws Exception;
}
