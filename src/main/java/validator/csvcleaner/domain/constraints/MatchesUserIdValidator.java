package validator.csvcleaner.domain.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import validator.csvcleaner.domain.CsvRow;

public class MatchesUserIdValidator implements ConstraintValidator<MatchesUserId, CsvRow> {


    @Override
    public boolean isValid(CsvRow row, ConstraintValidatorContext context) {
        if (row == null) return true;

        String id = row.getId();
        String userId = row.getUserId();

        return userId != null && id != null
                && userId.contains(id);
    }
}