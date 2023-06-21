package jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BooleanHealthySerializer extends JsonSerializer<Boolean> {
    @Override
    public void serialize(Boolean src, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeString(src ? "healthy" : "unHealthy");
    }
}
