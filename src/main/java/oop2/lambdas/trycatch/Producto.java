package oop2.lambdas.trycatch;

public class Producto {
    private String name;

    private Producto(String name) {
        this.name = name;
    }

    public static Producto productoAs(String name) {
        return new Producto(name);
    }

    public String name() {
        return this.name;
    }
}
