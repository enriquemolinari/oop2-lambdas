package oop2.lambdas.otros;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
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
//        if (!this.security.checkAddPermission(userId)) {
//            throw new RuntimeException("sin permisos para agregar");
//        }
//        this.productos.add(producto);
        ejecutarSiTienePermisos(userId, "sin permisos para agregar",
                (uid) -> this.security.checkAddPermission(uid),
                () -> this.productos.add(producto));
    }

    public void removeProducto(String userId, Producto producto) {
//        if (!this.security.checkRemovePermission(userId)) {
//            throw new RuntimeException("sin permisos para remover");
//        }
//        this.productos.remove(producto);
        ejecutarSiTienePermisos(userId, "sin permisos para remover",
                (uid) -> this.security.checkRemovePermission(uid),
                () -> this.productos.remove(producto));
    }

    public List<Producto> listAll(String userId) {
//        if (!this.security.checkListPermission(userId)) {
//            throw new RuntimeException("sin permisos para listar");
//        }
//        return Collections.unmodifiableList(this.productos);
        return ejecutarSiTienePermisos(userId,
                "sin permisos para listar",
                (uid) -> this.security.checkListPermission(uid),
                () -> Collections.unmodifiableList(this.productos));
    }

    public <T> T ejecutarSiTienePermisos(String userId,
                                         String errorMsg,
                                         Predicate<String> verificarPermiso,
                                         Supplier<T> supplier) {
        if (!verificarPermiso.test(userId)) {
            throw new RuntimeException(errorMsg);
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
