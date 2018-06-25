package hm.binkley.nullitudinous;

import lombok.NonNull;

public final class LombokNonNullField_Generated {
    private final int aPrimitiveField;
    private final String aNullableField;
    @NonNull
    private final String aNonNullField;

    @java.beans.ConstructorProperties(
            {"aPrimitiveField", "aNullableField", "aNonNullField"})
    public LombokNonNullField_Generated(final int aPrimitiveField,
            final String aNullableField, final String aNonNullField) {
        this.aPrimitiveField = aPrimitiveField;
        this.aNullableField = aNullableField;
        this.aNonNullField = aNonNullField;
    }
}
