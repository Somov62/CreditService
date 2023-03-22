package com.SberTech.CreditService.Controllers;

import com.SberTech.CreditService.Entities.CreditDeal;
import com.SberTech.CreditService.Exceptions.NotFoundException;
import com.SberTech.CreditService.Models.CreditDealModel;
import com.SberTech.CreditService.Services.CreditDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deals")
public class CreditDealController {

    @Autowired
    private CreditDealService service;

    @GetMapping
    public ResponseEntity<List<CreditDealModel>> get() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable(name = "id") long id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(name = "id") long id) {
        try {
            return ResponseEntity.ok(service.delete(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity post(@RequestBody CreditDealModel body) {
        var entity = service.add(body);
        return ResponseEntity.ok(entity);
    }

    @PutMapping
    public ResponseEntity put(@RequestBody CreditDealModel body) {
        try {
            var entity = service.edit(body);
            return ResponseEntity.ok(entity);
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
