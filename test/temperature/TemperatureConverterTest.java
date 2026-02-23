package com.example.temperature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private TemperatureConverter converter;

    @BeforeEach
    void setUp() {
        converter = new TemperatureConverter();
    }

    // 1. Verify conversion from Celsius to Fahrenheit
    @Test
    void testCelsiusToFahrenheit_knownValues() {
        assertEquals(68.0, converter.celsiusToFahrenheit(20), 0.001);
        assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.001);
    }

    // 2. Verify conversion from Fahrenheit to Celsius
    @Test
    void testFahrenheitToCelsius_knownValues() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.001);
        assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.001);
    }

    // 3. Ensure negative Celsius converts correctly
    @Test
    void testNegativeCelsius() {
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40), 0.001);
    }

    // 4. Ensure large Fahrenheit converts correctly
    @Test
    void testLargeFahrenheit() {
        assertEquals(537.78, converter.fahrenheitToCelsius(1000), 0.01);
    }

    // 5. Verify that 0°C equals 32°F
    @Test
    void testZeroCelsiusEquals32Fahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.001);
    }
}