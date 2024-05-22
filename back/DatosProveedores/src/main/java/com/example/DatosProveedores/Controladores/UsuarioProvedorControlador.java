package com.example.DatosProveedores.Controladores;

import com.example.DatosProveedores.Modelos.UsuarioProvedor;
import com.example.DatosProveedores.Servicios.UsuarioProvedorServicio;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("storeapi/v1/usuarioProvedor")
public class UsuarioProvedorControlador {

    @Autowired
    UsuarioProvedorServicio usuarioProvedorServicio;

    @PostMapping

    public ResponseEntity<?> guardarUsuarioProvedo(@RequestBody UsuarioProvedor datosUsuarioProvedor){
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioProvedorServicio.guardarUsuarioProvedor(datosUsuarioProvedor));

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
    }
}
