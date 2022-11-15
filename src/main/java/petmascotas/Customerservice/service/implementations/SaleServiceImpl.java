package petmascotas.Customerservice.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petmascotas.Customerservice.model.dto.SaleDto;
import petmascotas.Customerservice.model.entity.Pet;
import petmascotas.Customerservice.model.entity.Sale;
import petmascotas.Customerservice.model.entity.SaleReport;
import petmascotas.Customerservice.model.mapper.SaleMapper;
import petmascotas.Customerservice.repository.PetRepository;
import petmascotas.Customerservice.repository.SaleRepository;
import petmascotas.Customerservice.service.SaleService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final PetRepository petRepository;

    @Autowired
    private SaleMapper saleMapper;

    @Override
    public SaleDto add(SaleDto saleDto) throws Exception {
        Sale sale = saleMapper.toEntity(saleDto);
        SaleDto saleDtoNew = saleMapper.toDto(saleRepository.save(sale));

        Pet pet = petRepository.findById(saleDto.getPet_id()).orElse(null);
        System.out.println(pet);
        if (pet != null) {
            pet.setStatus(2);
            petRepository.save(pet);
        }

        return saleDtoNew;
    }

    @Override
    public List<SaleReport> get() throws Exception {
        return saleRepository.findSales();
    }
}
