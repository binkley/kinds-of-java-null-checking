package hm.binkley.nullitudinous;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class LombokNonNullField {
    private final int aPrimitiveField;
    private final String aNullableField;
    @NonNull
    private final String aNonNullField;
}
