package validator.csvcleaner.domain;

import java.util.Set;

import jakarta.validation.ConstraintViolation;

public class ErrorRow {
    private final CsvRow row;
    private final Set<? extends ConstraintViolation<?>> violations;

    public ErrorRow(CsvRow row, Set<? extends ConstraintViolation<?>> violations) {
        this.row = row;
        this.violations = violations;
    }

    public CsvRow getRow() { return row; }
    public Set<? extends ConstraintViolation<?>> getViolations() { return violations; }
}
