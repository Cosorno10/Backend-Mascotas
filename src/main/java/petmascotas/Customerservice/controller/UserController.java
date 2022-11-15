package petmascotas.Customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petmascotas.Customerservice.model.dto.UserDto;
import petmascotas.Customerservice.service.implementations.UserServiceImpl;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping()
    public ResponseEntity add(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok().body(userService.add(userDto));
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok().body(userService.login(userDto));
    }

    @PutMapping
    public ResponseEntity modify(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok().body(userService.modify(userDto));
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok().body(userService.delete(userDto));
    }

    @GetMapping
    public ResponseEntity get() throws Exception {
        return ResponseEntity.ok().body(userService.get());

    }
}
