package birthdaygreetings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class FileEmployeeRepositoryTest {

    @Test
    void shouldThrowIOExceptionWhenGetOverANonExistingFile() {
        FileEmployeeRepository fileEmployeeRepository = new FileEmployeeRepository("abasdfaddf.txt");
        assertThrows(IOException.class, fileEmployeeRepository::get);
    }

    @Test
    void shouldThrowParseExceptionWhenGetOverANonExistingFile() {
        FileEmployeeRepository fileEmployeeRepository = new FileEmployeeRepository("./src/test/resources/employee_bad_data.txt");
        assertThrows(ParseException.class, fileEmployeeRepository::get);
    }
}