package gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import model.Patient;

import java.lang.reflect.Type;

public class PatientSerializer implements JsonSerializer<Patient> {
    @Override
    public JsonElement serialize(Patient src, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();

        result.addProperty("name", src.getName()); //закоментил чтобы в файле убрать общий заголовок: "patients":
        result.addProperty("surName", src.getSurName());
        result.add("birthDate", context.serialize(src.getBirthDate()));
        result.add("health", context.serialize(src.isHealth()));
        return result;
    }
}
