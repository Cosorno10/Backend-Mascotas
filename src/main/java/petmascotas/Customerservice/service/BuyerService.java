package petmascotas.Customerservice.service;

import petmascotas.Customerservice.model.dto.BuyerDto;

import java.util.List;

public interface BuyerService {
    //Comprador = crear, consultar por DNI

    public BuyerDto add(BuyerDto buyerDto) throws Exception;

    public List<BuyerDto> get() throws Exception;


    BuyerDto getByDni(String dni) throws Exception;
}
