package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> predicates = new HashMap<>();

    public boolean isValid(T obj) {
        return predicates.values().stream().allMatch(predicate -> predicate.test(obj));
    }
}
