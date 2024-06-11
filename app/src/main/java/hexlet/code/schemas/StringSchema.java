package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

public class StringSchema extends BaseSchema<String> {


    public StringSchema required() {
        predicates.put("required", StringUtils::isNotEmpty);
        return this;
    }

    public StringSchema minLength(int minLength) {
        predicates.put("minLength", str -> str.length() >= minLength);
        return this;
    }

    public StringSchema contains(String subString) {
        predicates.put("contains", str -> str.contains(subString));
        return this;
    }
}
