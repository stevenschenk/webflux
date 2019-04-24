package nl.quintor.webfluxassignments.service;

import nl.quintor.webfluxassignments.Util.TemperatureConverter;
import nl.quintor.webfluxassignments.model.Temperature;
import nl.quintor.webfluxassignments.repository.TemperatureRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemperatureService {
    private TemperatureRepository repository;

    public TemperatureService(TemperatureRepository repository) {
        this.repository = repository;
    }

    /**
     * Find all temperatures in the database and convert them
     * all to degrees Celsius.
     * @return temperatures in degrees Celsius
     */
    public List<Temperature> findAll() {
        return repository.findAll()
                .stream()
                .map(TemperatureConverter::toCelsius)
                .collect(Collectors.toList());
    }

    /**
     * Get latest temperature and convert it to degrees
     * Celsius.
     * @return latest temperature in degrees Celsius.
     */
    public Temperature getLive() {
        return repository.findAll()
                .stream()
                .max(Comparator.comparing(Temperature::getTimestamp))
                .map(TemperatureConverter::toCelsius)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }
}
