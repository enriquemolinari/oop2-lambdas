package oop2.lambdas.otros;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class Productos {
    public static final String SIN_PERMISOS = "No tiene los permisos necesarios";
    private List<Producto> productos;
    private SecuritySubSystem security;

    public Productos(List<Producto> productos, SecuritySubSystem security) {
        this.security = security;
        this.productos = productos;
    }

    public void addProducto(String userId, Producto producto) {
        executeSiTienePermisos(userId, () -> this.productos.add(producto));
    }

    public void removeProducto(String userId, Producto producto) {
        executeSiTienePermisos(userId, () -> this.productos.remove(producto));
    }

    public List<Producto> listAll(String userId) {
        return executeSiTienePermisos(userId, () -> Collections.unmodifiableList(this.productos));
    }

    public <T> T executeSiTienePermisos(String userId, Supplier<T> supplier) {
        if (!this.security.checkPermission(userId)) {
            throw new RuntimeException(SIN_PERMISOS);
        }
        return supplier.get();
    }

    int cantidad() {
        return this.productos.size();
    }

    boolean contiene(Producto unProducto) {
        return this.productos.contains(unProducto);
    }
}
