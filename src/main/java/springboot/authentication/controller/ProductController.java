package springboot.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springboot.authentication.dto.Product;
import springboot.authentication.entity.UserInfo;
import springboot.authentication.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }

    @GetMapping("/all")
   // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_LAB_TECH') or hasRole('ROLE_STAFF')")                  //people who can go inside the private room
    public List<Product> getAllTheProducts() {
        return service.getProducts();
    }
    @GetMapping("/{id}")
   // @PreAuthorize("hasAuthority('ROLE_USER')")
    //@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_HR') or hasRole('ROLE_USER')")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_LAB_TECH','ROLE_STAFF','ROLE_STUDENT')")                           /* first 3 of them can access both the lab and
                                                                                                                  private room but student can access only the lab */
    public Product getProductById(@PathVariable int id) {
        return service.getProduct(id);
    }
}