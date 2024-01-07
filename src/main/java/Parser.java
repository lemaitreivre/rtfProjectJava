import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class Parser {

    public static List<Country> parse() throws IOException {
        List<Country> countries = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(
                Path.of("src\\main\\java\\Happy.csv"))) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                String[] args;
                csvReader.readNext();
                while ((args = csvReader.readNext()) != null) {
                    countries.add(
                            new Country(
                                    args[0],
                                    args[1],
                                    Integer.parseInt(args[2]),
                                    Double.parseDouble(args[3]),
                                    Double.parseDouble(args[4]),
                                    Double.parseDouble(args[5]),
                                    Double.parseDouble(args[6]),
                                    Double.parseDouble(args[7]),
                                    Double.parseDouble(args[8]),
                                    Double.parseDouble(args[9]),
                                    Double.parseDouble(args[10]),
                                    Double.parseDouble(args[11])
                            )
                    );
                }
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
        }
        return countries;
    }
}