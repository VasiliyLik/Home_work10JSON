package gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatebirthdateSerializer implements JsonSerializer<Date> {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {

        return new JsonPrimitive(dateFormat.format(src));
    }
}
