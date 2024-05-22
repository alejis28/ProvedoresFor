package com.example.DatosProveedores.Helpers;

import org.springframework.stereotype.Component;

@Component
public class ValidacionUbicacion {
    public boolean validarPais(String pais) throws Exception {
        if (pais.length() == 0) {
            throw new Exception("El pais no puede estar vacio");
        }
        if (pais.length() > 50) {
            throw new Exception("El pais no puede tener mas de 50 caracteres");
        }
        String regex = "^[a-zA-Z]+$";

        if (!ValidarPatron.evaluarPatron(regex, pais)) {
            throw new Exception("revisa el pais ingresado ya que solo puede tener letras y espacios");
        }
        return true;
    }

    public boolean validarCiudad(String ciudad) throws Exception {
        if (ciudad.length() == 0) {
            throw new Exception("La Ciudad no puede estar vacia");
        }
        if (ciudad.length() > 50) {
            throw new Exception("La Ciudad no puede tener mas de 50 caracteres");
        }
        String regex = "^[a-zA-Z]+$";

        if (!ValidarPatron.evaluarPatron(regex, ciudad)) {
            throw new Exception("revisa la ciudad ingresada ya que solo puede tener letras");
        }
        return true;
    }

    public boolean validarDepartamento(String departamento) throws Exception {
        if (departamento.length() == 0) {
            throw new Exception("El departamento no puede estar vacio");
        }
        if (departamento.length() > 50) {
            throw new Exception("El departamento no puede tener mas de 50 caracteres");
        }
        String regex = "^[a-zA-Z]+$";

        if (!ValidarPatron.evaluarPatron(regex, departamento)) {
            throw new Exception("revisa el departamento ingresado ya que solo puede tener letras");
        }
        return true;
    }
}