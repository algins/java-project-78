package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema required() {
        predicates.put("required", map -> map != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        predicates.put("sizeof", map -> map.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        predicates.put("shape", map -> schemas.entrySet()
            .stream()
            .allMatch(entry -> {
                BaseSchema<T> schema = entry.getValue();
                var value = map.get(entry.getKey());
                return schema.isValid((T) value);
            }));

        return this;
    }
}
