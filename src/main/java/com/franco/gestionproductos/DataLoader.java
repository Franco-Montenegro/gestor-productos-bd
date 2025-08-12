package com.franco.gestionproductos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final ProductoRepository repo;

    public DataLoader(ProductoRepository repo) { this.repo = repo; }

    @Override
    public void run(String... args) {
        if (repo.count() == 0) {
            var lista = List.of(
                    crear("Teclado", new BigDecimal("12990"), 20),
                    crear("Mouse", new BigDecimal("7990"), 50),
                    crear("Monitor", new BigDecimal("129990"), 10)
            );
            repo.saveAll(lista);
        }
    }

    private Producto crear(String nombre, BigDecimal precio, int stock) {
        var p = new Producto();
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setStock(stock);
        return p;
    }
}
