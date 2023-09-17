package rw.rca.rentalresidence.controller;

import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.rca.rentalresidence.model.Property;
import rw.rca.rentalresidence.service.PropertyService;
import rw.rca.rentalresidence.util.CustomResponse;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/properties")
@Api(tags = "Properties")
public class PropertyController {

   private final PropertyService propertyService;

   public PropertyController(PropertyService propertyService) {
      this.propertyService = propertyService;
   }

   @PostMapping
   public ResponseEntity<CustomResponse<Property>> save(@RequestBody Property property) {
      try {
         return ResponseEntity.created(null).body(new CustomResponse<>("Property saved successfully", propertyService.save(property), true));
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().body(new CustomResponse<>("Property not saved", null, false));
      }
   }

   @GetMapping
   public ResponseEntity<CustomResponse<List<Property>>> findAll() {
      try {
         return ResponseEntity
               .ok(new CustomResponse<>("Properties found successfully", propertyService.findAll(), true));
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().body(new CustomResponse<>("Properties not found", null, false));
      }
   }

    @GetMapping("/pageable")
    public ResponseEntity<CustomResponse<Page<Property>>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                  @RequestParam(value = "limit", defaultValue = "10") int limit) {
        try {
           Pageable pageable = PageRequest.of(page, limit, Sort.Direction.ASC, "id");
            return ResponseEntity
                    .ok(new CustomResponse<>("Properties found successfully", propertyService.findAll(pageable), true));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>("Properties not found", null, false));
        }
    }

   @GetMapping("/{id}")
   public ResponseEntity<CustomResponse<Property>> findById(@PathVariable String id) {
      try {
         return ResponseEntity
               .ok(new CustomResponse<>("Property found successfully", propertyService.findById(id), true));
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().body(new CustomResponse<>("Property not found", null, false));
      }
   }

   @PutMapping("/{id}")
   public ResponseEntity<CustomResponse<Property>> update(@PathVariable String id, @RequestBody Property property) {
      try {
         return ResponseEntity
               .ok(new CustomResponse<>("Property updated successfully", propertyService.update(id, property), true));
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().body(new CustomResponse<>("Property not updated", null, false));
      }
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<CustomResponse<?>> deleteById(@PathVariable String id) {
      try {
         propertyService.deleteById(id);
         return ResponseEntity.accepted().body(new CustomResponse<>("Property deleted successfully", null, true));
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().body(new CustomResponse<>("Property not deleted", null, false));
      }
   }

   @GetMapping("/search")
   public ResponseEntity<CustomResponse<List<Property>>> search(@RequestParam Map<String, String> query) {
      try {
         return ResponseEntity
               .ok(new CustomResponse<>("Properties found successfully", propertyService.search(query), true));
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().body(new CustomResponse<>("Properties not found", null, false));
      }
   }

   @GetMapping("/address/{address_query}")
   public ResponseEntity<CustomResponse<List<Property>>> getPropertyByAddress(
         @PathVariable("address_query") String address_query) {
      try {
         return ResponseEntity.ok(new CustomResponse<>("Properties found successfully",
               propertyService.findByAddress(address_query), true));
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().body(new CustomResponse<>("Properties not found", null, false));
      }
   }

}
