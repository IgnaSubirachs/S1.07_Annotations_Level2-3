# Java Object to JSON Serializer

📄 **Description - Exercise Statement**

This project consists of creating a custom Java annotation that allows serializing a Java object into a JSON file.  
The annotation must specify the directory where the generated JSON file will be saved.  
The main objective is to use reflection to access object fields and dynamically create the JSON without external libraries.

---

💻 **Technologies Used**

- Java 8+
- Standard Java Reflection API
- Standard Java I/O (FileWriter)
- No external libraries (e.g., no Gson, no Jackson)

---

📋 **Requirements**

- Java JDK 8 or higher
- Java IDE (such as IntelliJ IDEA, Eclipse, or VS Code with Java extensions)
- A folder structure ready for Java projects
- Manual creation of the output directory (or modify the code to auto-create it)

---

🛠️ **Installation**

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/java-json-serializer.git
   ```
2. Open the project in your preferred IDE.
3. Make sure the JDK is properly configured.
4. (Optional) Create the `output/` directory manually at the root of the project.

---

▶️ **Execution**

1. Compile the project:
   ```bash
   javac *.java
   ```
2. Run the `Main` class:
   ```bash
   java Main
   ```
3. After execution, a JSON file will be generated inside the `output/` directory:
    - Example: `output/Persona.json`

Example JSON output:

```json
{
  "nom": "Joan",
  "edat": "30"
}
```

---

✅ **Notes**

- Make sure the `output` directory exists before running the application, or handle its creation in the code.
- Fields are serialized in a basic key-value format.
- All string and numeric values are enclosed in quotes.

---