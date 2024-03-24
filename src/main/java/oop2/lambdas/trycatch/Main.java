package oop2.lambdas.trycatch;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var ep = new Export("/home/enrique/export-productos.txt");
        ep.exportProductos();
        var eu = new Export("/home/enrique/export-users.txt");
        eu.exportUsers();
    }
}
