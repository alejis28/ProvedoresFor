package com.example.DatosProveedores.Helpers;

import org.springframework.stereotype.Component;

@Component
public class ValidacionUsuarioProvedor {
    public boolean validarRazonSocial(String razonSocial)throws Exception{
        if (razonSocial.length()==0){
            throw new Exception("El nombre no puede estar vacio");
        }
        if (razonSocial.length()>50){
            throw  new Exception("el nombre no puede tener mas de 50 letras ");
        }
        String regex="^[a-zA-Z ]+$";
    if (!ValidarPatron.evaluarPatron(regex,razonSocial)){
        throw  new Exception(("revisa el nombre ingresado ya que solo puede tener letras y espacios "));
    }
    return  true;
}
    public boolean validarNit(String nit)throws Exception{
        if (nit.length()==0){
            throw new Exception("la longitud del nit no puede ser cero");
        }
        if (nit.length()>12){
            throw new Exception("la longitud del nit no puede ser mayor a 12");
        }
        String regex = "^[0-9]+$";
        if (!ValidarPatron.evaluarPatron(regex,nit)){
            throw new Exception("El nit ingresado solo puede tener numeros");
        }
        return true;
    }
    public boolean validarRepresentanteLegal(String representanteLegal)throws Exception {
        if (representanteLegal.length() == 0) {
            throw new Exception("El nombre no puede estar vacio");
        }
        if (representanteLegal.length() > 50) {
            throw new Exception("el nombre no puede tener mas de 50 letras ");
        }
        String regex = "^[a-zA-Z ]+$";
        if (!ValidarPatron.evaluarPatron(regex, representanteLegal)) {
            throw new Exception(("revisa el nombre ingresado ya que solo puede tener letras y espacios "));
        }
        return true;


    }
    public boolean validarTelefonoContacto(String telefonoContacto)throws Exception {
        if (telefonoContacto.length() == 0) {
            throw new Exception("la longitud del telefono Contacto no puede ser cero");
        }
        if (telefonoContacto.length() > 12) {
            throw new Exception("la longitud del telefono Contacto no puede ser mayor a 12");
        }
        String regex = "^[0-9]+$";
        if (!ValidarPatron.evaluarPatron(regex, telefonoContacto)) {
            throw new Exception("El telefono Contacto ingresado solo puede tener numeros");
        }
        return true;
    }
    public boolean validarEmail(String email)throws Exception{
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!ValidarPatron.evaluarPatron(regex,email)){
            throw new Exception("El correo no cumple con el formato adecuado");
        }
        if (email.length()==0){
            throw new Exception("la longitud del correo no puede ser cero");
        }

        return true;
    }



    }



