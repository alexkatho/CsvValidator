package validator.csvcleaner.io;


import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class CsvFileWriter implements AutoCloseable {

    private final CSVWriter writer;

    public CsvFileWriter(String path, char separator) throws IOException {
        writer = new CSVWriter(
                new FileWriter(path),
                separator,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END
        );
    }

    public void writeHeader(String... header) {
        writer.writeNext(header);
    }

    public void writeRow(String[] row) {
        writer.writeNext(row);
    }

    @Override
    public void close() throws Exception {
        writer.close();
    }
}
