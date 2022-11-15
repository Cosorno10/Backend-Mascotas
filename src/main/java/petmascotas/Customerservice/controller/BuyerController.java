package petmascotas.Customerservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petmascotas.Customerservice.model.dto.BuyerDto;
import petmascotas.Customerservice.service.implementations.BuyerServiceImpl;

@RestController
@RequestMapping(path = "buyer")
public class BuyerController {

    @Autowired
    private BuyerServiceImpl buyerService;

    @PostMapping
    public ResponseEntity add(@RequestBody BuyerDto buyerDto) throws Exception {
        return ResponseEntity.ok().body(buyerService.add(buyerDto));
    }
    @GetMapping(value = "/dni")
    public ResponseEntity getByDni(@RequestParam String dni) throws Exception {
        return ResponseEntity.ok().body(buyerService.getByDni(dni));
    }
}
