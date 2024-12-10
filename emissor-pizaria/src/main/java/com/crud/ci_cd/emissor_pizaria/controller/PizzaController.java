package com.crud.ci_cd.emissor_pizaria.controller;


import com.crud.ci_cd.emissor_pizaria.application.service.PizzaService;
import com.crud.ci_cd.emissor_pizaria.domain.pizza.CreatePizzaDTO;
import com.crud.ci_cd.emissor_pizaria.domain.pizza.PizzaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/api/pizzas")
@RequiredArgsConstructor
@Validated
public class PizzaController extends BaseController<CreatePizzaDTO> {

    private final PizzaService pizzaService;

    @Override
    public ResponseEntity<String> create(@RequestBody @Validated CreatePizzaDTO dto) {
        pizzaService.enviarPizza(dto);
        return ResponseEntity.ok("Pizza enviada com sucesso!");
    }

    @Override
    public ResponseEntity<String> update(@PathVariable @Min(0) Long id, @RequestBody @Validated PizzaDTO dto) {
        dto.setId(id);
        pizzaService.enviarPizza(dto);
        return ResponseEntity.ok("Pizza atualizada com sucesso!");
    }

    @Override
    public ResponseEntity<String> delete(@PathVariable @Min(0) Long id) {
        PizzaDTO pizzaDTO = new PizzaDTO();
        pizzaDTO.setId(id);
        pizzaDTO.setStatus(false);
        pizzaService.enviarPizza(pizzaDTO);
        return ResponseEntity.ok("Pizza deletada logicamente com sucesso!");
    }

    @Override
    public ResponseEntity<String> getById(@PathVariable @Min(0) Long id) {
        return ResponseEntity.ok("Endpoint de consulta implementado no receptor.");
    }

    @Override
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("Endpoint de listagem implementado no receptor.");
    }
}


