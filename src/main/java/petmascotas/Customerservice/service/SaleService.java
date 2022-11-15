package petmascotas.Customerservice.service;

import petmascotas.Customerservice.model.dto.SaleDto;
import petmascotas.Customerservice.model.entity.SaleReport;

import java.util.List;

public interface SaleService {
    //Sale = Crear, listar

    public SaleDto add(SaleDto saleDto) throws Exception;

    public List<SaleReport> get() throws Exception;

}
