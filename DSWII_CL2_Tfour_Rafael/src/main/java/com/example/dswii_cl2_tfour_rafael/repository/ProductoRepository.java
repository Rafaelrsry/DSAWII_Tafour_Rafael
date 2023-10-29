package com.example.dswii_cl2_tfour_rafael.repository;

import com.example.dswii_cl2_tfour_rafael.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> buscarPorNombre(String nombre);

    @Query("SELECT p FROM Producto p WHERE p.cantidad > 10 AND p.cantidad < 100")
    List<Producto> buscarProductosEntre10y100();

    @Query(nativeQuery = true, value = "SELECT * FROM Producto p WHERE YEAR(p.fecha_vencimiento) = 2024")
    List<Producto> buscarProductosConVencimiento2024();

}

