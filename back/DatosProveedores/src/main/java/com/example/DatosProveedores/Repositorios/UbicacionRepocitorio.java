package com.example.DatosProveedores.Repositorios;

import com.example.DatosProveedores.Modelos.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionRepocitorio  extends JpaRepository<Ubicacion,Integer> {
}
