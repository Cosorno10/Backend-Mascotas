package petmascotas.Customerservice.service.implementations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petmascotas.Customerservice.model.dto.UserDto;
import petmascotas.Customerservice.model.entity.User;
import petmascotas.Customerservice.model.mapper.UserMapper;
import petmascotas.Customerservice.repository.UserRepository;
import petmascotas.Customerservice.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto add(UserDto userDto) throws Exception {
        User user = userMapper.toEntity(userDto);
        UserDto userDtoNew = userMapper.toDto(userRepository.save(user));

        return userDtoNew;
    }

    @Override
    public UserDto modify(UserDto userDto) throws Exception {
        User userFind = userRepository.findById(userDto.getId()).orElse(null);

        if (userFind != null) {
            User user = userMapper.toEntity(userDto);
            UserDto userDtoModify = userMapper.toDto(userRepository.save(user));
            return userDtoModify;
        }

        return null;

    }

    @Override
    public UserDto delete(UserDto userDto) throws Exception {
        User userFind = userRepository.findById(userDto.getId()).orElse(null);

        if (userFind != null) {
            userFind.setStatus(userFind.getStatus() == 0 ? 1 : 0);
            UserDto petDtoModify = userMapper.toDto(userRepository.save(userFind));
            return petDtoModify;
        }

        return null;

    }

    @Override
    public List<UserDto> get() throws Exception {
        User User;
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.toDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getByStatus(String Status) throws Exception {
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.toDto(user))
                .collect(Collectors.toList());

    }

    public UserDto login(UserDto userDto) throws Exception {
        User userLogin = userRepository.findByUsername(userDto.getUsername());

        if(userLogin == null)
            throw new Exception("Usuario no encontrado.");

        if(userLogin.getStatus() == 0)
            throw new Exception("Usuario Inactivo.");

        if(!userLogin.getPassword().equals(userDto.getPassword()))
            throw new Exception("Contraseña incorrecta.");

        return userMapper.toDto(userLogin);
    }
}



