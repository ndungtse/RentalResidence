package rw.rca.rentalresidence.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rw.rca.rentalresidence.model.Property;
import rw.rca.rentalresidence.service.PropertyService;

@RestController
@RequestMapping("/properties")
public class PropertyController {

   private final PropertyService propertyService;

   public PropertyController(PropertyService propertyService) {
      this.propertyService = propertyService;
   }

   @GetMapping
   public List<Property> findAll() {
      return propertyService.findAll();
   }

   @GetMapping("/{id}")
   public Property findById(@PathVariable String id) {
      return propertyService.findById(id);
   }

   @PostMapping
   public Property save(@RequestBody Property property) {
      return propertyService.save(property);
   }

   @PutMapping("/{id}")
   public Property update(@PathVariable String id, @RequestBody Property property) {
      return propertyService.update(id, property);
   }

   @DeleteMapping("/{id}")
   public void deleteById(@PathVariable String id) {
      propertyService.deleteById(id);
   }
}

