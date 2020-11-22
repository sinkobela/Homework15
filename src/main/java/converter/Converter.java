package converter;

public class Converter {
    public double fahrenheitToCelsius(double temperature) {
        if (temperature < -459.67) {
            throw new IllegalArgumentException("Temperature is below absolute zero!");
        }
        return (temperature - 32) * 5 / 9;
    }

    public double celsiusToFahrenheit(double temperature) {
        if (temperature < -273.15) {
            throw new IllegalArgumentException("Temperature is below absolute zero!");
        }
        return temperature * 9 / 5 + 32;
    }
}
