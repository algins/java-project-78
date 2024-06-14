package hexlet.code.schemas;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        predicates.put("required", StringUtils::isNotEmpty);
        return this;
    }

    public StringSchema minLength(int minLength) {
        predicates.put("minLength", str -> Optional.ofNullable(str).orElse("").length() >= minLength);
        return this;
    }

    public StringSchema contains(String subString) {
        predicates.put("contains", str -> str.contains(subString));
        return this;
    }
}
