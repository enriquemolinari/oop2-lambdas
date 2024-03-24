package oop2.lambdas.trycatch;

import org.jooq.lambda.Unchecked;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Export {
    private String filePath;

    public Export(String filePath) {
        this.filePath = filePath;
    }

    public void exportProductos() throws IOException {
        var productos = new Productos().all();
        File aFile = new File(this.filePath);
        try (Writer writer = new FileWriter(aFile)) {
            writer.write("product name" + System.lineSeparator());
            for (Producto producto : productos) {
                writer.write(producto.name() + System.lineSeparator());
            }
            //productos.stream().forEach(producto -> writer.write(producto.name() + System.lineSeparator()));
            //productos.stream().forEach(Unchecked.consumer(producto -> writer.write(producto.name() + System.lineSeparator())));
        }
    }

    public void exportUsers() throws IOException {
        var users = new Users().all();
        try (Writer writer = new FileWriter(new File(this.filePath))) {
            writer.write("username, email" + System.lineSeparator());
            for (User user : users) {
                writer.write(user.userName() + "," + user.email() + System.lineSeparator());
            }
        }
    }

    public void exportUsers2() throws Exception {
        var users = new Users().all();
        export(Unchecked.consumer((writer) -> writer.write("username, email" + System.lineSeparator())),
                Unchecked.biConsumer((user, writer1) -> writer1.write(user.userName() + "," + user.email() + System.lineSeparator())),
                users);
    }

    public <T> void export(Consumer<Writer> writeHeader,
                           BiConsumer<T, Writer> writeElement,
                           List<T> listToExport) throws Exception {
        File aFile = new File(this.filePath);
        try (Writer writer = new FileWriter(aFile)) {
            writeHeader.accept(writer);
            for (T elem : listToExport) {
                writeElement.accept(elem, writer);
            }
        }
    }

    public void export(Consumer<Writer> consumer) throws Exception {
        File aFile = new File(this.filePath);
        try (Writer writer = new FileWriter(aFile)) {
            consumer.accept(writer);
        }
    }
}
