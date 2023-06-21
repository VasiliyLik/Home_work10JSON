package jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class BooleanHealthyDeserializer extends JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {
        if ("healthy".equals(parser.getText())) {
            return Boolean.TRUE;
        }
        if ("unHealthy".equals(parser.getText())) {
            return Boolean.FALSE;
        }
        return null;
    }
}
