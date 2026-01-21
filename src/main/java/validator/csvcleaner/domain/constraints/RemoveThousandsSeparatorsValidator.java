package validator.csvcleaner.domain.constraints;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RemoveThousandsSeparatorsValidator
        implements ConstraintValidator<RemoveThousandsSeparators, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) return true;

        String cleaned = value.replace(".", "").replace(",", "");
        return cleaned.matches("\\d+");
    }
}
