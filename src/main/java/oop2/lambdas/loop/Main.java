package oop2.lambdas.loop;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Concurso p1 = new Concurso("Concurso1",
                LocalDateTime.of(2024, 3, 22, 10, 30, 10),
                LocalDateTime.of(2024, 4, 22, 10, 30, 10));
        Concurso p2 = new Concurso("Concurso2",
                LocalDateTime.of(2024, 5, 22, 10, 30, 10),
                LocalDateTime.of(2024, 6, 22, 10, 30, 10));
        Concurso p3 = new Concurso("Concurso3",
                LocalDateTime.of(2024, 7, 22, 10, 30, 10),
                LocalDateTime.of(2024, 8, 22, 10, 30, 10));

        var ps = new Concursos(p1, p2, p3);


//    var conE = ps.nombresQueEmpiezanConE();
//    var pares = ps.nombresCuyaCantidadDeLetrasEsPar();

//        var conE = ps.filtro((p) -> p.nombreEmpiezaCon("E"));
//
//        var pares = ps.filtro((p) -> p.nombreConCantidadParDeLetras());
        /*
         * new Condicion() {
         *
         * @Override public boolean condicion(Persona p) { return
         * p.nombreEmpiezaCon("E"); } }
         */

//        for (Persona persona : conE) {
//            System.out.println(persona);
//        }
//
//        for (Persona persona : pares) {
//            System.out.println(persona);
//        }

    }
}
