package validator.csvcleaner.domain.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueIdValidator.class)
@Documented
public @interface UniqueId {
	String message() default "id must be unique";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
