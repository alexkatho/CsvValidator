package validator.csvcleaner.app;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import validator.csvcleaner.domain.CsvRow;
import validator.csvcleaner.domain.ErrorRow;
import validator.csvcleaner.domain.ProcessingResult;
import validator.csvcleaner.io.CsvFileReader;
import validator.csvcleaner.io.CsvFileWriter;
import validator.csvcleaner.service.CsvProcessor;
import validator.csvcleaner.service.NumberStringSanitizer;

public class Application {

	public static void main(String[] args) {
		try {
			InputStream in = CsvFileReader.class.getResourceAsStream("/input.csv");
			if (in == null) {
				System.err.println("input.csv konnte in den Resources nicht gefunden werden!");
				return;
			}

			InputStreamReader readerStream = new InputStreamReader(in);
			CsvFileReader reader = new CsvFileReader(';');
			List<CsvRow> rows = reader.read(readerStream);

			NumberStringSanitizer sanitizer = new NumberStringSanitizer();
			CsvProcessor processor = new CsvProcessor(sanitizer);
			ProcessingResult result = processor.process(rows);

			String outputDir = System.getProperty("user.home") + File.separator + "Dokumente";
			File outDirFile = new File(outputDir);
			if (!outDirFile.exists()) {
				outDirFile.mkdirs(); 
			}

			String validPath = outputDir + File.separator + "valid.csv";
			String invalidPath = outputDir + File.separator + "invalid.csv";

			try (CsvFileWriter validWriter = new CsvFileWriter(validPath, ';');
					CsvFileWriter invalidWriter = new CsvFileWriter(invalidPath, ';')) {

				validWriter.writeHeader("id", "userid", "wert");
				for (CsvRow row : result.valid()) {
					validWriter.writeRow(row.toCsvRowWithoutStartzahl());
				}

				invalidWriter.writeHeader("id", "userid", "startzahl", "wert", "errors");
				for (ErrorRow error : result.invalid()) {
					String[] rowData = { error.getRow().getId(), error.getRow().getUserId(),
							error.getRow().getStartzahl(), error.getRow().getWert(), error.getViolations().toString() };
					invalidWriter.writeRow(rowData);
				}
			}

			System.out.println("CSV Processing completed. Outputs in: " + outputDir);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
