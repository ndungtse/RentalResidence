package rw.rca.rentalresidence.controller;

import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import rw.rca.rentalresidence.model.Property;
import rw.rca.rentalresidence.service.PropertyService;
import rw.rca.rentalresidence.util.CustomResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
@Api(tags = "Properties")
public class PropertyController {

   private final PropertyService propertyService;

   public PropertyController(PropertyService propertyService) {
      this.propertyService = propertyService;
   }

   @GetMapping
   public CustomResponse<List<Property>> findAll() {
      try {
         return new CustomResponse<>("Properties found successfully", propertyService.findAll(), true);
      } catch (Exception e) {
         e.printStackTrace();
         return new CustomResponse<>("Properties not found", null, false);
      }
   }

   @GetMapping("/{id}")
   public CustomResponse<Property> findById(@PathVariable String id) {
      try {
         return new CustomResponse<>("Property found successfully", propertyService.findById(id), true);
      } catch (Exception e) {
         e.printStackTrace();
         return new CustomResponse<>("Property not found", null, false);
      }
   }

   @PostMapping
   public CustomResponse<Property> save(@RequestBody Property property) {
      try {
         return new CustomResponse<>("Property saved successfully", propertyService.save(property), true);
      } catch (Exception e) {
         e.printStackTrace();
         return new CustomResponse<>("Property not saved", null, false);
      }
   }

   @PutMapping("/{id}")
   public CustomResponse<Property> update(@PathVariable String id, @RequestBody Property property) {
      try {
         return new CustomResponse<>("Property updated successfully", propertyService.update(id, property), true);
      } catch (Exception e) {
         e.printStackTrace();
         return new CustomResponse<>("Property not updated", null, false);
      }
   }

   @DeleteMapping("/{id}")
   public CustomResponse<?> deleteById(@PathVariable String id) {
      try {
         propertyService.deleteById(id);
         return new CustomResponse<>("Property deleted successfully", null, true);
      } catch (Exception e) {
         e.printStackTrace();
         return new CustomResponse<>("Property not deleted", null, false);
      }
   }
}

