package rw.rca.rentalresidence.controller;

import org.springframework.web.bind.annotation.*;
import rw.rca.rentalresidence.model.Property;
import rw.rca.rentalresidence.service.PropertyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
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

