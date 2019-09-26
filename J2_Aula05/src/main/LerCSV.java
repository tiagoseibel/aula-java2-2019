package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class LerCSV {
    //
    // Doc: https://commons.apache.org/proper/commons-csv/user-guide.html
    //
    public static void main(String[] args)
            // Throws para exceções de arquivos
            throws FileNotFoundException, IOException {
        // Ler arquivo
        Reader arq = new FileReader("livros.csv");
        // Transformar em registros
        Iterable<CSVRecord> linhas = CSVFormat.EXCEL // Tipo
                        .withDelimiter(';') // Delimitador
                        .withHeader("Autor", "Titulo") // Headers
                        .parse(arq);
        // Listar dados
        for (CSVRecord i : linhas) {
            String autor = i.get("Autor");
            String titulo = i.get("Titulo");
            System.out.println(autor + " - " + titulo);
        }
    }
}
