package hm.binkley.nullitudinous;

import javax.validation.constraints.NotNull;

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
}
