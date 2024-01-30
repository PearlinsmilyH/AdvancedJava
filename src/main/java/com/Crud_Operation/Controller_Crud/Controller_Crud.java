package com.Crud_Operation.Controller_Crud;


import com.Crud_Operation.Model_Crud.Model_Crud;
import com.Crud_Operation.Service_Crud.Service_Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Homepage")
public class Controller_Crud {
    /*@GetMapping("/")
    public String getuserinfo(){
        return "welcome";
    }

    @GetMapping("/{name}/{address}")
    public String getusername(@PathVariable(value = "name") String n,@PathVariable(value = "address") String a){

        return "Hai " + n + " From " + a + " Welcome to Spring boot Curd Operation";

    }*/

    @Autowired
    Service_Crud service_crud;

    @PostMapping("/Registeration") //insert
    public Model_Crud addvalues(@RequestBody Model_Crud model_crud){
        return this.service_crud.addvalues(model_crud);
    }
    @GetMapping ("/Getdata")
    public List<Model_Crud> getdata(){
        return this.service_crud.getalldata();
    }
    @GetMapping("/Getparticulardata/{id}")
    public Optional<Model_Crud> getdata(@PathVariable(value ="id") Integer i ){

        return this.service_crud.getparticulardata(i);
    }
    @GetMapping("/Getparticularname/{name}") //read
    public Optional<Model_Crud> getdata(@PathVariable(value ="name") String n ){

        return this.service_crud.getparticulardata1(n);
    }
    @PutMapping("/updatedata/{id}") //update
    public Model_Crud updatedata(@PathVariable(value = "id") Integer id, @RequestBody Model_Crud model_crud){

        return this.service_crud.updatedata(id,model_crud);

    }
    @DeleteMapping("/Deletedata/{id}")  //delete
    public String deletedata(@PathVariable(value = "id") Integer id){

       return this.service_crud.deletedata(id);
    }
}
