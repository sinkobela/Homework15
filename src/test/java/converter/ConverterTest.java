package converter;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ConverterTest {
    Converter converter;

    @BeforeEach
    void setUp() {
        converter = new Converter();
    }

    @Test
    @DisplayName("WHEN 50 fahrenheit is given THEN 10 celsius is returned")
    void testFahrenheitToCelsius1() {
        //GIVEN
        //WHEN
        double received = converter.fahrenheitToCelsius(50);
        //THEN
        assertThat(received).isEqualTo(10);
    }

    @Test
    @DisplayName("WHEN 100 fahrenheit is given THEN 37.77777777777778 celsius is returned")
    void testFahrenheitToCelsius2() {
        //GIVEN
        //WHEN
        double received = converter.fahrenheitToCelsius(100);
        //THEN
        assertThat(received).isEqualTo(37.77777777777778);
    }

    @Test
    @DisplayName("WHEN colder temperature is given then absolute zero THEN IllegalArgumentExp is returned")
    void testFahrenheitToCelsius3() {
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> converter.fahrenheitToCelsius(-460));
    }

    @Test
    @DisplayName("WHEN 40 celsius is given THEN 104 fahrenheit is returned")
    void testCelsiusToFahrenheit1() {
        //GIVEN
        //WHEN
        double received = converter.celsiusToFahrenheit(40);
        //THEN
        assertThat(received).isEqualTo(104);
    }

    @Test
    @DisplayName("WHEN colder temperature is given then absolute zero THEN IllegalArgumentExp is returned")
    void testCelsiusToFahrenheit2() {
        //GIVEN
        //WHEN
        //THEN
        assertThrows(IllegalArgumentException.class, () -> converter.celsiusToFahrenheit(-274));
    }

}
