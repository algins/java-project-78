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
}
