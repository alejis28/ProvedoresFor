package com.example.DatosProveedores.Servicios;
import com.example.DatosProveedores.Helpers.ValidacionUsuarioProvedor;
import com.example.DatosProveedores.Modelos.UsuarioProvedor;
import com.example.DatosProveedores.Repositorios.UsuarioProvedorRepocitorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioProvedorServicio {
    @Autowired
    ValidacionUsuarioProvedor validacionUsuarioProvedor;
    @Autowired
    UsuarioProvedorRepocitorio usuarioProvedorRepocitorio;

    public UsuarioProvedor guardarUsuarioProvedor(UsuarioProvedor datosUsuarioProvedor) throws Exception {
        if (!validacionUsuarioProvedor.validarRazonSocial(datosUsuarioProvedor.getRazonSocial())) {

            throw new IllegalArgumentException("razon social invàlida");

        }
        if (!validacionUsuarioProvedor.validarNit(datosUsuarioProvedor.getNit())) {

            throw new IllegalArgumentException("nit invàlido");

        }
        if (!validacionUsuarioProvedor.validarRepresentanteLegal(datosUsuarioProvedor.getRepresentanteLegal())) {

            throw new IllegalArgumentException("Nombre no valido");

        }
        if (!validacionUsuarioProvedor.validarTelefonoContacto(datosUsuarioProvedor.getTelefonoContacto())) {

            throw new IllegalArgumentException("razon social invàlida");

        }
        if (!validacionUsuarioProvedor.validarEmail(datosUsuarioProvedor.getEmail())) {

            throw new IllegalArgumentException("Email invàlida");

        }


        try {
            return usuarioProvedorRepocitorio.save(datosUsuarioProvedor);

        } catch (Exception e) {
            throw new Exception("error al guardar provedor: " + e.getMessage());
        }

    }
}

