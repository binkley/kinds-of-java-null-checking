package hm.binkley.nullitudinous;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotNull;
import java.util.Set;

import static java.lang.System.out;
import static javax.validation.Validation.buildDefaultValidatorFactory;

public final class HibernateNotNullField {
    private final int aPrimitiveField;
    private final String aNullableField;
    private final @NotNull String aNonNullField;

    public HibernateNotNullField(final int aPrimitiveField,
            final String aNullableField, final String aNonNullField) {
        this.aPrimitiveField = aPrimitiveField;
        this.aNullableField = aNullableField;
        this.aNonNullField = aNonNullField;
    }

    public static void main(final String... args) {
        final Set<ConstraintViolation<HibernateNotNullField>> validated
                = buildDefaultValidatorFactory().getValidator()
                .validate(new HibernateNotNullField(1, null, null));
        validated.forEach(out::println);
    }
}
