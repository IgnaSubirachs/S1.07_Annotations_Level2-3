public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("Joan", "Bonanit",42);
            JsonSerializer.serialize(person);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
