package petmascotas.Customerservice.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petmascotas.Customerservice.model.dto.BuyerDto;
import petmascotas.Customerservice.model.entity.Buyer;
import petmascotas.Customerservice.model.mapper.BuyerMapper;
import petmascotas.Customerservice.repository.BuyerRepository;
import petmascotas.Customerservice.service.BuyerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;

    @Autowired
    private BuyerMapper buyerMapper;

    @Override
    public BuyerDto add(BuyerDto buyerDto) throws Exception {
        Buyer buyer = buyerMapper.toEntity(buyerDto);
        BuyerDto buyerDtoNew = buyerMapper.toDto(buyerRepository.save(buyer));

        return buyerDtoNew;
    }

    @Override
    public List<BuyerDto> get() throws Exception {
        return buyerRepository.findAll()
                .stream()
                .map(buyer -> buyerMapper.toDto(buyer))
                .collect(Collectors.toList());
    }

    @Override
    public BuyerDto getByDni(String dni) throws Exception {
        return buyerMapper.toDto(buyerRepository.findByDni(dni));
    }

}
