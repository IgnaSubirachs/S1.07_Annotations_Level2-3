import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class JsonSerializer {

    public static void serialize(Object object) {
        Class<?> clazz = object.getClass();


        if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
            throw new RuntimeException("Class " + clazz.getSimpleName() + " is not annotated with @JsonSerializable");
        }

        JsonSerializable annotation = clazz.getAnnotation(JsonSerializable.class);
        String directory = annotation.directory();

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\n");

        Field[] fields = clazz.getDeclaredFields();

        try {
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                String fieldName = fields[i].getName();
                Object fieldValue = fields[i].get(object);

                jsonBuilder.append(String.format("  \"%s\": \"%s\"", fieldName, fieldValue));

                if (i < fields.length - 1) {
                    jsonBuilder.append(",\n");
                } else {
                    jsonBuilder.append("\n");
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error accessing fields: " + e.getMessage());
        }

        jsonBuilder.append("}");

        try (FileWriter writer = new FileWriter(directory + "/" + clazz.getSimpleName() + ".json")) {
            writer.write(jsonBuilder.toString());
            System.out.println("Object serialized successfully!");
        } catch (IOException e) {
            throw new RuntimeException("Error writing JSON file: " + e.getMessage());
        }
    }
}
