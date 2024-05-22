package com.example.DatosProveedores.Modelos;

import jakarta.persistence.*;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="usuarioProvedor")
public class UsuarioProvedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(name ="razonSocial",nullable = false,length = 50)
    private String razonSocial;

    @Column(name ="nit",nullable = false,length = 20)
    private String nit;

    @Column(name="representanteLegal",nullable = false,length = 50)
    private String representanteLegal;

    @Column(name="telefonoContacto",nullable = false,length = 15)
    private String telefonoContacto;

    @Column(name="email",nullable = false,length = 100)
    private String email;

    @Column(name="direccion",nullable = false,length = 150)
    private String direccion;

    public UsuarioProvedor() {
    }

    public UsuarioProvedor(Integer id_usuario, String direccion, String razonSocial, String nit, String representanteLegal, String telefonoContacto, String email) {
        this.id_usuario = id_usuario;
        this.direccion = direccion;
        this.razonSocial = razonSocial;
        this.nit = nit;
        this.representanteLegal = representanteLegal;
        this.telefonoContacto = telefonoContacto;
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
