package validator.csvcleaner.io;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import validator.csvcleaner.domain.CsvRow;

public class CsvFileReader {

    private final char separator;

    public CsvFileReader(char separator) {
        this.separator = separator;
    }

    public List<CsvRow> read(Reader reader) throws Exception {
    	 CSVReader csvReader = new CSVReaderBuilder(reader)
    	            .withCSVParser(new CSVParserBuilder().withSeparator(separator).build())
    	            .build();
    	    List<String[]> rows = csvReader.readAll();
    	    csvReader.close();

        List<CsvRow> result = new ArrayList<>();
        for (int i = 1; i < rows.size(); i++) { // skip header
            String[] r = rows.get(i);
            result.add(new CsvRow(r[0], r[1], r[2], r[3]));
        }
        return result;
    }
}
