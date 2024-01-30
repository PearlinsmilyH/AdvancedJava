package com.Crud_Operation.Service_Crud;


import com.Crud_Operation.Exception.ResourceNotFoundException;
import com.Crud_Operation.Model_Crud.Model_Crud;
import com.Crud_Operation.Repository_Crud.Repo_Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Service_Crud {
    @Autowired
    Repo_Crud repo_crud;
    public Model_Crud addvalues(Model_Crud model_crud){
        return this.repo_crud.save(model_crud);
    }
    public List<Model_Crud> getalldata(){
        return this.repo_crud.findAll();

    }
    public Optional<Model_Crud> getparticulardata(Integer id){
        return this.repo_crud.findById(id);
    }
    public Optional<Model_Crud> getparticulardata1(String n){
        return this.repo_crud.findByName(n);
    }

    public Model_Crud updatedata(Integer id,Model_Crud model_crud){
        Model_Crud olddata=this.repo_crud.findById(id).orElseThrow(()->new ResourceNotFoundException("User data not found"));

        olddata.setName(model_crud.getName());
        olddata.setAddress(model_crud.getAddress());
        return this.repo_crud.save(olddata);
    }
    public String deletedata(Integer id){
        this.repo_crud.deleteById(id);
        return "deleted";
    }
}
