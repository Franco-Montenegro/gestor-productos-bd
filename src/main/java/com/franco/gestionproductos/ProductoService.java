package com.franco.gestionproductos;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listar() { return repo.findAll(); }

    public Producto obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Producto crear(Producto p) {
        return repo.save(p);
    }

    public Producto actualizar(Long id, Producto p) {
        return repo.findById(id)
                .map(db -> {
                    db.setNombre(p.getNombre());
                    db.setPrecio(p.getPrecio());
                    db.setStock(p.getStock());
                    return repo.save(db);
                })
                .orElse(null);
    }

    public void eliminar(Long id) { repo.deleteById(id); }
}
