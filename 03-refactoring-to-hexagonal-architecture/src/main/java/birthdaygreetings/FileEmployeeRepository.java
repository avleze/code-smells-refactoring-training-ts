package birthdaygreetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FileEmployeeRepository implements EmployeeRepository {

    private String fileName;

    public FileEmployeeRepository(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Employee> get() throws IOException, ParseException {
        List<Employee> employees = new ArrayList<>();
        try {

            BufferedReader in = new BufferedReader(new FileReader(this.fileName));

            List<String> lines = readLinesFromFile(in);

            for (String eachLine : lines) {
                employees.add(mapEmployee(eachLine));
            }
        } catch (IOException exception) {
            throw InfraestructureException.becauseFileCannotBeFound(exception);
        } catch (ParseException exception) {
            throw InfraestructureException.becauseFileCannotBeParsed(exception);
        }

        return employees;
    }

    private static List<String> readLinesFromFile(final BufferedReader in) throws IOException {
        String line = "";
        line = in.readLine(); // skip header
        List<String> lines = new ArrayList<>();
        while ((line = in.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    private static Employee mapEmployee(final String line) throws ParseException {
        String[] employeeData = line.split(", ");
        final String firstName = employeeData[1];
        final String lastName = employeeData[0];
        final String birthDate = employeeData[2];
        final String email = employeeData[3];
        return new Employee(firstName, lastName, birthDate, email);
    }
}
