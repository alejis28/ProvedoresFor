package com.example.DatosProveedores.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name="ubicacion")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ubicacion;

    @Column(name ="Pais",nullable = false,length = 50)
    private String pais;

    @Column(name="Ciudad",nullable = false,length = 50)
    private  String ciudad;

    @Column(name="Departamento",nullable = false,length = 50)
    private String departamento;

    public Ubicacion() {
    }

    public Ubicacion(Integer id_ubicacion, String departamento, String ciudad, String pais) {
        this.id_ubicacion = id_ubicacion;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.pais = pais;
    }



    public String getDepartamento() {
        return departamento;}

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
