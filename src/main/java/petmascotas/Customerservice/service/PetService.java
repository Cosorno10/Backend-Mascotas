package petmascotas.Customerservice.service;

import petmascotas.Customerservice.model.dto.PetDto;

import java.util.List;

public interface PetService {
    //crear, modificar, eliminar, listar, listar por tipo

    public PetDto add(PetDto petDto) throws Exception;

    public PetDto modify(PetDto petDto) throws Exception;

    public PetDto delete(PetDto petDto) throws Exception;

    public List<PetDto> get(String type, int status) throws Exception;

    public List<PetDto> getByType(String type) throws Exception;
}
