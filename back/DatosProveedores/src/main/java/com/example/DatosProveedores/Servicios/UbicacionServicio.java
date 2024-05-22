package com.example.DatosProveedores.Servicios;

import com.example.DatosProveedores.Helpers.ValidacionUbicacion;
import com.example.DatosProveedores.Modelos.Ubicacion;
import com.example.DatosProveedores.Modelos.UsuarioProvedor;
import com.example.DatosProveedores.Repositorios.UbicacionRepocitorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionServicio {

    @Autowired
    ValidacionUbicacion validacionUbicacion;
    @Autowired
    UbicacionRepocitorio ubicacionRepocitorio;

    public Ubicacion guardarUbicacion(Ubicacion datosUbiacion) throws Exception {
        if (!validacionUbicacion.validarPais(datosUbiacion.getPais())) {

            throw new IllegalArgumentException("pais invàlida solo letras y espacio");

        }

        try {
            return ubicacionRepocitorio.save(datosUbiacion);

        } catch (Exception e) {
            throw new Exception("error al guardar ubicacion: " + e.getMessage());
        }
    }

}