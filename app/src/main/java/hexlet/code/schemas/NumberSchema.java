package hexlet.code.schemas;

import java.util.Optional;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        predicates.put("required", num -> Optional.ofNullable(num).orElse(0) != 0);
        return this;
    }

    public NumberSchema positive() {
        predicates.put("positive", num -> Optional.ofNullable(num).orElse(0) >= 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        predicates.put("range", num -> num >= min && num <= max);
        return this;
    }
}
