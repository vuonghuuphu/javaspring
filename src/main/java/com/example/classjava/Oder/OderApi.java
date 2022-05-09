package com.example.classjava.Oder;

import com.example.classjava.Class.Grade;
import com.example.classjava.Class.GradeService;
import com.example.classjava.Class.Student;
import com.example.classjava.Class.StudentService;
import com.example.classjava.Product.Product;
import com.example.classjava.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/oders")
public class OderApi {

    @Autowired
    OderService oderService;
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Oder>> getlist() {
        return ResponseEntity.ok(oderService.findAll());
    }

    @PostMapping
    public ResponseEntity<Oder> save(@RequestBody Oder p) {
        return ResponseEntity.ok(oderService.save(p));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> detail(@PathVariable int id) {
        Optional<Oder> optional = oderService.findById(id);
        if (!optional.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!oderService.findById(id).isPresent()){
            ResponseEntity.badRequest().build();
        }
        oderService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/adddetail")
    public ResponseEntity<?> addoderdetail(
            @RequestParam int idproduct,
            @RequestParam int idoder,
            @RequestParam int quantity
    ) {
        Optional<Oder> optionaloder = oderService.findById(idoder);
        Optional<Product> optionalproduct = productService.findById(idproduct);
        if (!optionaloder.isPresent() || !optionaloder.isPresent()){
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
        boolean result = oderService.Addoderdetail(optionaloder.get(),optionalproduct.get(),quantity);
        if (!result){
            return new ResponseEntity<>("add oder error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("add oder success", HttpStatus.OK);
    }
}
