package hm.binkley.nullitudinous;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class TypeWithLombokNonNullField {
    private final int aPrimitiveField;
    private final String aNullableField;
    @NonNull
    private final String aNonNullField;
}
