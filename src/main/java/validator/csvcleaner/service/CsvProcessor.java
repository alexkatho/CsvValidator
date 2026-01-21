package validator.csvcleaner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import validator.csvcleaner.domain.CsvRow;
import validator.csvcleaner.domain.ErrorRow;
import validator.csvcleaner.domain.ProcessingResult;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import jakarta.validation.*;

public class CsvProcessor {

    private final Validator validator;
    private final NumberStringSanitizer sanitizer;

    public CsvProcessor(NumberStringSanitizer sanitizer) {
        this.sanitizer = sanitizer;

        // Validator ohne EL
        ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        this.validator = factory.getValidator();
    }

    public ProcessingResult process(List<CsvRow> rows) {
        List<CsvRow> valid = new ArrayList<>();
        List<ErrorRow> invalid = new ArrayList<>();

        for (CsvRow row : rows) {
            Set<ConstraintViolation<CsvRow>> violations = validator.validate(row);

            if (violations.isEmpty()) {
                row.setWert(sanitizer.removeThousandsSeparators(row.getWert()));
                valid.add(row);
            } else {
                invalid.add(new ErrorRow(row, violations));
            }
        }

        return new ProcessingResult(valid, invalid);
    }
}
