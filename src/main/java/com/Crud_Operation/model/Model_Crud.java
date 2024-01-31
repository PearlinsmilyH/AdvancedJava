package com.Crud_Operation.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "Regsiteration")
public class Model_Crud {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Reg_ID")
    private int Id;

    @Column(name = "Reg_NAME")
    @Schema(description = "Registered name", example = "Raja")
    private String name;

    @Column(name = "Reg_ADDRESS")
    private String Address;

    public Model_Crud(int id, String name, String address) {
        Id = id;
        this.name = name;
        Address = address;
    }

    public Model_Crud() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
