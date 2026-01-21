package validator.csvcleaner.domain;

import java.util.List;

public record ProcessingResult(List<CsvRow> valid, List<ErrorRow> invalid) {}
