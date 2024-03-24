package oop2.lambdas;

public class MainLambdas {
    public static void main(String[] args) {
        // parameters   ->  body
        // (a, b, c)    ->  { }

        // 1 parametro   ->  una expresión
        // (a)    ->  return a + 1;
        // a    ->  a + 1;

        // porque es posible esta asignacion?
        Runnable r = (/* parameters */) -> { /* body */ };

        // ¿ es posible esta asignacion?
        // Predicate p = (/* parameters */) -> { /* body */ };

        // ¿ es posible esta asignacion?
        // Consumer c = (/* parameters */) -> { /* body */ };

        // ¿ es posible esta asignacion?
        // Supplier s = (/* parameters */) -> { /* body */ };

        // Cual o cuales de las tres opciones es correcta?
//        Function<Long, Long> f1 = x -> x + 1;
//        Function<Long, Long> f2 = (x, y) -> x + 1;
//        Function<Long, Boolean> f3 = x -> x == 1;
    }
}