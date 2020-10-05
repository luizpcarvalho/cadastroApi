package restproject.cadastroapi.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Repeatable(CepValidation.List.class)
@Documented

@NotBlank(message = "Cep é obrigatório")
@Size(max = 10)
@Pattern(message = "Cep inválido", regexp = "^[0-9]{5}-[0-9]{3}$")
public @interface CepValidation {

    String MESSAGE = "Cep inválido";

    String message() default MESSAGE;

    Class<? extends Payload>[] payload() default {};

    Class<?>[] groups() default {};

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        CepValidation[] value();
    }

}
