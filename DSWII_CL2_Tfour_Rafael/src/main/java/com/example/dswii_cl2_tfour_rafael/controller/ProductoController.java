package com.example.dswii_cl2_tfour_rafael.controller;

import com.example.dswii_cl2_tfour_rafael.entity.Producto;
import com.example.dswii_cl2_tfour_rafael.repository.ProductoRepository;
import com.example.dswii_cl2_tfour_rafael.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoService.mostrarProductos();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Integer id) {
        return productoService.obtenerProductoPorId(id);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crearNuevoProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        return productoService.actualizarProductoExistente(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProductoPorId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Producto> buscarPorNombre(@PathVariable String nombre) {
        return productoRepository.buscarPorNombre(nombre);
    }

    @GetMapping("/cantidad-between")
    public List<Producto> buscarProductosEntre10y100() {
        return productoRepository.buscarProductosEntre10y100();
    }

    @GetMapping("/vencimiento-2024")
    public List<Producto> buscarProductosConVencimiento2024() {
        return productoRepository.buscarProductosConVencimiento2024();
    }


}
