package nl.quintor.webfluxassignments.Util;

import nl.quintor.webfluxassignments.InvalidTemperatureUnitException;
import nl.quintor.webfluxassignments.model.Temperature;
import nl.quintor.webfluxassignments.model.Unit;

public class TemperatureConverter {
    public static Temperature toFahrenheit(Temperature temperature) throws InvalidTemperatureUnitException {
        return convertAnyToFahrenheit(temperature);
    }

    public static Temperature toCelsius(Temperature temperature) throws InvalidTemperatureUnitException {
        return convertAnyToCelsius(temperature);
    }


    private static Temperature celsiusToFahrenheit(Temperature temperature) {
        temperature.setUnit(Unit.FAHRENHEIT);
        temperature.setTemperature((temperature.getTemperature() * 1.8) + 32);

        return temperature;
    }

    private static Temperature fahrenheitToCelsius(Temperature temperature) {
        temperature.setUnit(Unit.CELSIUS);
        temperature.setTemperature((temperature.getTemperature() - 32) / 1.8);

        return temperature;
    }

    private static Temperature convertAnyToCelsius(Temperature temperature) throws InvalidTemperatureUnitException {
        if(temperature.getUnit() == null)
            throw new InvalidTemperatureUnitException();

        switch (temperature.getUnit()) {

            case CELSIUS:
                return temperature;
            case FAHRENHEIT:
                return fahrenheitToCelsius(temperature);
            default:
                throw new InvalidTemperatureUnitException();
        }
    }

    private static Temperature convertAnyToFahrenheit(Temperature temperature) throws InvalidTemperatureUnitException {
        if(temperature.getUnit() == null)
            throw new InvalidTemperatureUnitException();

        switch (temperature.getUnit()) {
            case CELSIUS:
                return celsiusToFahrenheit(temperature);
            case FAHRENHEIT:
                return temperature;
            default:
                throw new InvalidTemperatureUnitException();
        }
    }
}
