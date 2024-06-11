package hexlet.code.schemas;

import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

public class StringSchema {
    private Predicate<String> requiredPredicate = str -> true;
    private Predicate<String> minLengthPredicate = str -> true;
    private Predicate<String> containsPredicate = str -> true;

    public StringSchema required() {
        requiredPredicate = StringUtils::isNotEmpty;
        return this;
    }

    public StringSchema minLength(int minLength) {
        minLengthPredicate = str -> str.length() >= minLength;
        return this;
    }

    public StringSchema contains(String subString) {
        containsPredicate = str -> str.contains(subString);
        return this;
    }

    public boolean isValid(String str) {
        return requiredPredicate
            .and(minLengthPredicate)
            .and(containsPredicate)
            .test(str);
    }
}
