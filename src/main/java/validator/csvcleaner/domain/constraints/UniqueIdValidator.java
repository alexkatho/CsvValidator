package validator.csvcleaner.domain.constraints;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueIdValidator implements ConstraintValidator<UniqueId, String> {

	private static final Set<String> SEEN = new HashSet<>();

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && SEEN.add(value);
	}
}
