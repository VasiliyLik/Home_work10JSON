package gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class BooleanHealthySerializer implements JsonSerializer<Boolean> {
    @Override
    public JsonElement serialize(Boolean src, Type type, JsonSerializationContext context) {
        return new JsonPrimitive(src ? "healthy" : "unhealthy");
    }
}
