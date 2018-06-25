package hm.binkley.nullitudinous;

import static java.lang.System.out;
import static javax.validation.Validation.buildDefaultValidatorFactory;

public final class RunTheExample {
    public static void main(final String... args) {
        out.println();
        out.println("--- \u001B[1m\u001B[32mAll good\u001B[0m:"
                + " Lombok correctly finds nothing wrong in constructor for"
                + " non-null value in @NonNull parameter");
        new LombokNonNullField(1, null, "3");

        out.println();
        out.println("--- \u001B[1m\u001B[32mAll good\u001B[0m:"
                + " Lombok correctly throws in constructor for"
                + " null value in @NonNull parameter");
        try {
            new LombokNonNullField(1, null, null);
            throw new Error("Did not throw");
        } catch (final NullPointerException e) {
            e.printStackTrace(out);
        }

        out.println();
        out.println("--- \u001B[1m\u001B[31mLombok with Hibernate\u001B[0m:"
                + " Lombok never throws -- it ignores Hibernate's @NotNull");
        try {
            new HibernateNotNullField(1, null, null);
            throw new Error("Did not throw");
        } catch (final NullPointerException | Error e) {
            e.printStackTrace(out);
        }

        out.println();
        out.println("--- \u001B[1m\u001B[32mAll good\u001B[0m:"
                + " Hibernate correctly finds nothing wrong in validate for"
                + " not-null value in @NotNull field");
        buildDefaultValidatorFactory().getValidator()
                .validate(new HibernateNotNullField(1, null, "3"))
                .forEach(out::println);

        out.println();
        out.println("--- \u001B[1m\u001B[32mAll good\u001B[0m:"
                + " Hibernate correctly complains in validate for"
                + " null value in @NotNull field");
        buildDefaultValidatorFactory().getValidator()
                .validate(new HibernateNotNullField(1, null, null))
                .forEach(out::println);

        out.println();
        out.println("--- \u001B[1m\u001B[31mHibernate with Lombok\u001B[0m:"
                + " Hibernate has no chance to run -- Lombok"
                + " already threw in the constructor");
        try {
            buildDefaultValidatorFactory().getValidator()
                    .validate(new LombokNonNullField(1, null, null))
                    .forEach(out::println);
            throw new Error("Did not throw");
        } catch (final NullPointerException e) {
            e.printStackTrace(out);
        }
    }
}
