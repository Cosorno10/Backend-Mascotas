package petmascotas.Customerservice.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petmascotas.Customerservice.model.dto.PetDto;
import petmascotas.Customerservice.model.entity.Pet;
import petmascotas.Customerservice.model.mapper.PetMapper;
import petmascotas.Customerservice.repository.PetRepository;
import petmascotas.Customerservice.service.PetService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;

    @Override
    public PetDto add(PetDto petDto) throws Exception {
        Pet pet = petMapper.toEntity(petDto);
        PetDto petDtoNew = petMapper.toDto(petRepository.save(pet));

        return petDtoNew;
    }

    @Override
    public PetDto modify(PetDto petDto) throws Exception {
        Pet petFind = petRepository.findById(petDto.getId()).orElse(null);

        if(petFind != null){
            Pet pet = petMapper.toEntity(petDto);
            PetDto petDtoModify = petMapper.toDto(petRepository.save(pet));
            return petDtoModify;
        }

        return null;
    }

    @Override
    public PetDto delete(PetDto petDto) throws Exception {
        Pet petFind = petRepository.findById(petDto.getId()).orElse(null);

        if(petFind != null){
            petFind.setStatus(petFind.getStatus() == 0 ? 1 : 0);
            PetDto petDtoModify = petMapper.toDto(petRepository.save(petFind));
            return petDtoModify;
        }

        return null;
    }

    @Override
    public List<PetDto> get(String type, int status) throws Exception {
        System.out.println(status);
        if(!type.isEmpty() && status >= 0)
            return this.getByTypeAndStatus(type, status);
        else if (status >= 0) {
            return this.getByTypeStatus(status);

        }

        return petRepository.findAll()
                .stream()
                .map(pet -> petMapper.toDto(pet))
                .collect(Collectors.toList());
    }

    @Override
    public List<PetDto> getByType(String type) throws Exception {
        return petRepository.findByType(type)
                .stream()
                .map(pet -> petMapper.toDto(pet))
                .collect(Collectors.toList());
    }

    public List<PetDto> getByTypeStatus(int status) throws Exception {
        return petRepository.findByStatus(status)
                .stream()
                .map(pet -> petMapper.toDto(pet))
                .collect(Collectors.toList());
    }

    public List<PetDto> getByTypeAndStatus(String type, int status) throws Exception {
        return petRepository.findByTypeAndStatus(type, status)
                .stream()
                .map(pet -> petMapper.toDto(pet))
                .collect(Collectors.toList());
    }
}
