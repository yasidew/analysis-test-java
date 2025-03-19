import java.io.*;
import java.sql.*;
import java.util.*;

public class ProblematicApp {

    // 🚨 1. Security Vulnerability: SQL Injection
    public void insecureDatabaseQuery(String userInput) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + userInput + "'"; // 🚨 SQL Injection Risk
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("User: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🚀 2. Performance Issue: Inefficient String Concatenation
    public String inefficientStringConcatenation(List<String> words) {
        String result = "";
        for (String word : words) {
            result += word + " "; // 🚨 Inefficient string concatenation in loop (Use StringBuilder)
        }
        return result;
    }

    // 🔍 3. Code Readability & Maintainability: Magic Number
    public double calculateInterest(double principal) {
        return principal * 0.05; // 🚨 Magic number (should use a constant variable)
    }

    // 🔥 4. Resource & Memory Management: Resource Leak
    public void readFile(String filename) {
        try {
            FileReader reader = new FileReader(filename); // 🚨 No proper resource management
            char[] buffer = new char[1024];
            reader.read(buffer);
            System.out.println(new String(buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 🚨 Missing reader.close() leads to resource leak
    }

    // ⚠️ 5. Exception Handling: Catching Generic Exception
    public void processRequest() {
        try {
            int result = 100 / 0; // 🚨 Division by zero
        } catch (Exception e) { // 🚨 Catching generic Exception instead of specific ArithmeticException
            System.out.println("An error occurred.");
        }
    }

    // 🛑 6. Deprecated & Compatibility Issues: Using Outdated Method
    public void useDeprecatedMethod() {
        Date date = new Date(2025, 3, 18); // 🚨 Uses deprecated constructor (should use Calendar or LocalDate)
        System.out.println("Date: " + date);
    }

    // 🏗️ 7. Object-Oriented Design Issues: Violation of Encapsulation
    public class User {
        public String password; // 🚨 Should be private with getter/setter
    }

    // ☁️ 8. API & Cloud Security: Hardcoded API Key
    private static final String API_KEY = "12345-SECRET-API-KEY"; // 🚨 Hardcoded API key

    // 🔑 9. Business Logic Vulnerability: Flawed Authentication
    public boolean authenticate(String username, String password) {
        return username.equals("admin") && password.equals("password123"); // 🚨 Hardcoded credentials
    }

    // 🏢 10. Compliance Violation: Missing Documentation
    public void undocumentedMethod() {
        // 🚨 No comments or explanation for what this method does
        System.out.println("This method is undocumented.");
    }
}
