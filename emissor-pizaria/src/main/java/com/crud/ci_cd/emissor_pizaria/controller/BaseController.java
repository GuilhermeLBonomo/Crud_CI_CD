package com.crud.ci_cd.emissor_pizaria.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
public abstract class BaseController<T> {

    @PostMapping
    public abstract ResponseEntity<String> create(@RequestBody @Validated T dto);

    @PutMapping("/{id}")
    public abstract ResponseEntity<String> update(@PathVariable @Validated Long id, @Validated @RequestBody T dto);

    @DeleteMapping("/{id}")
    public abstract ResponseEntity<String> delete(@PathVariable @Validated Long id);

    @GetMapping("/{id}")
    public abstract ResponseEntity<String> getById(@PathVariable @Validated Long id);

    @GetMapping
    public abstract ResponseEntity<String> getAll();
}

