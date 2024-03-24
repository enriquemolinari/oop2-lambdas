package oop2.lambdas.trycatch;

import java.util.List;

public class Productos {

    public List<Producto> all() {
        return List.of(Producto.productoAs("p1"),
                Producto.productoAs("p2"),
                Producto.productoAs("p3"),
                Producto.productoAs("p4"),
                Producto.productoAs("p5"),
                Producto.productoAs("p6"),
                Producto.productoAs("p7")
        );
    }
}
