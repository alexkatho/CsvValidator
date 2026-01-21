package validator.csvcleaner.domain.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MatchesUserIdValidator.class)
@Documented
public @interface MatchesUserId {
    String message() default "userid must be a valid email and contain id";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
