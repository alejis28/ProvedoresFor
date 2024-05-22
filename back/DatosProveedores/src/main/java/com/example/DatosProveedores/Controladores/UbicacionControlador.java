package com.example.DatosProveedores.Controladores;

import com.example.DatosProveedores.Modelos.Ubicacion;
import com.example.DatosProveedores.Servicios.UbicacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("storeapi/v1/ubicacion")
public class UbicacionControlador {


    @Autowired
    UbicacionServicio ubicacionServicio;



    @PostMapping

    public ResponseEntity<?> guardarUbicacion(@RequestBody Ubicacion datosUbicacion){

        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ubicacionServicio.guardarUbicacion(datosUbicacion));

        }catch(Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());


        }

    }

}


