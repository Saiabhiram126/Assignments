package com.example.grade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class StudentGradeParameterizedTest {

    // 1️⃣ Use @ValueSource to verify valid positive marks do not throw
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 50, 100})
    @DisplayName("Adding valid positive marks should not throw exception")
    void testValidPositiveMarks(int marks) {
        StudentGradeCalculator calc = new StudentGradeCalculator();
        assertDoesNotThrow(() -> calc.addMarks(marks));
    }

    // 2️⃣ Use @CsvSource to test multiple sets of marks and expected averages
    @ParameterizedTest
    @CsvSource({
            "20, 30, 25.0",
            "40, 60, 50.0",
            "100, 80, 90.0"
    })
    @DisplayName("Check calculateAverage with multiple values")
    void testCalculateAverageWithCsv(int m1, int m2, double expectedAvg) {
        StudentGradeCalculator calc = new StudentGradeCalculator();
        calc.addMarks(m1);
        calc.addMarks(m2);
        assertEquals(expectedAvg, calc.calculateAverage());
    }

    // 3️⃣ Use @CsvSource to test PASS/FAIL with sets of marks
    @ParameterizedTest
    @CsvSource({
            "50, 60, PASS",
            "30, 20, FAIL",
            "40, 40, PASS"
    })
    @DisplayName("Check PASS/FAIL with multiple mark sets")
    void testGetResultWithCsv(int m1, int m2, String expected) {
        StudentGradeCalculator calc = new StudentGradeCalculator();
        calc.addMarks(m1);
        calc.addMarks(m2);
        assertEquals(expected, calc.getResult());
    }

    // 4️⃣ Use @ValueSource to confirm negative marks throw an exception
    @ParameterizedTest
    @ValueSource(ints = {-1, -50})
    @DisplayName("Adding negative marks should throw IllegalArgumentException")
    void testNegativeMarks(int invalidMarks) {
        StudentGradeCalculator calc = new StudentGradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.addMarks(invalidMarks));
    }

    // 5️⃣ Use @MethodSource for complex test data: multiple marks lists
    @ParameterizedTest
    @MethodSource("provideMarksForAverage")
    @DisplayName("Complex test data for averages using MethodSource")
    void testComplexAverage(int[] marks, double expectedAvg) {
        StudentGradeCalculator calc = new StudentGradeCalculator();
        for (int mark : marks) {
            calc.addMarks(mark);
        }
        assertEquals(expectedAvg, calc.calculateAverage());
    }

    static Stream<Arguments> provideMarksForAverage() {
        return Stream.of(
                Arguments.of(new int[]{10, 20, 30, 40}, 25.0),
                Arguments.of(new int[]{50, 50, 50, 50, 50}, 50.0),
                Arguments.of(new int[]{90, 80, 70}, 80.0)
        );
    }

    // Extra: Parameterized test for no marks added
    @Test
    @DisplayName("calculateAverage with no marks should throw exception")
    void testNoMarksAdded() {
        StudentGradeCalculator calc = new StudentGradeCalculator();
        assertThrows(IllegalStateException.class, calc::calculateAverage);
    }
}