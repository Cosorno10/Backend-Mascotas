package petmascotas.Customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import petmascotas.Customerservice.model.dto.SaleDto;
import petmascotas.Customerservice.service.implementations.SaleServiceImpl;

//http://localhost:8094/sale/add
//http://localhost:8094/sale/get-all
//http://localhost:8094/sale/

@RestController
@RequestMapping(path = "sale")
public class SaleController {

    @Autowired
    private SaleServiceImpl saleService;

    @PostMapping
    public ResponseEntity add(@RequestBody SaleDto saleDto) throws Exception{
        System.out.println(saleDto);
        return ResponseEntity.ok().body(saleService.add(saleDto));
    }

    @GetMapping
    public ResponseEntity get() throws Exception {
        return ResponseEntity.ok().body(saleService.get());
    }

}
