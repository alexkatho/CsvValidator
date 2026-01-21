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
@Constraint(validatedBy = RemoveThousandsSeparatorsValidator.class)
@Documented
public @interface RemoveThousandsSeparators {
    String message() default "wert must be numeric after removing thousands separators";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
