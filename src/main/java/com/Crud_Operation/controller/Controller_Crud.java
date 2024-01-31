package com.Crud_Operation.controller;


import com.Crud_Operation.model.Model_Crud;
import com.Crud_Operation.service.Service_Crud;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "CRUD", description = "Swagger crud operation")
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
    @Parameters({
            @Parameter(name = "ID", description = "Search Data by Id"),
            @Parameter(name = "Name", description = "Enter the name", required = true),

    })
    @GetMapping ("/Getdata")
    public List<Model_Crud> getdata(){
        return this.service_crud.getalldata();
    }
    @Operation(
            summary = "Get data by Id",
            description = "Get data by giving id.",
            tags = { "CRUD", "get by ID" })
    @GetMapping("/Getparticulardata/{id}")
    public Optional<Model_Crud> getdata(@PathVariable(value ="id") Integer i ){

        return this.service_crud.getparticulardata(i);
    }
    @Operation(
            summary = "Get data by Name",
            description = "Get data by giving Name.",
            tags = { "CRUD", "get by Name" })
    @GetMapping("/Getparticularname/{name}") //read
    public Optional<Model_Crud> getdata(@PathVariable(value ="name") String n ){

        return this.service_crud.getparticulardata1(n);
    }
    @Operation(
            summary = "Update a data by Id",
            description = "Update a data by giving Id.",
            tags = { "CRUD", "Put by Id" })
    @PutMapping("/updatedata/{id}") //update
    public Model_Crud updatedata(@PathVariable(value = "id") Integer id, @RequestBody Model_Crud model_crud){

        return this.service_crud.updatedata(id,model_crud);

    }

    @Operation(
            summary = "Delete a data by Id",
            description = "Delete a data by specifying Id.",
            tags = { "CRUD", "Delete by Id" })
    @DeleteMapping("/Deletedata/{id}")  //delete
    public String deletedata(@PathVariable(value = "id") Integer id){

       return this.service_crud.deletedata(id);
    }
}
