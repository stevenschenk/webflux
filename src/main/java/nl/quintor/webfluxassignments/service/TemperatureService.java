package nl.quintor.webfluxassignments.service;

import nl.quintor.webfluxassignments.Util.TemperatureConverter;
import nl.quintor.webfluxassignments.model.Temperature;
import nl.quintor.webfluxassignments.repository.TemperatureRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Service
public class TemperatureService {
    private TemperatureRepository repository;

    public TemperatureService(TemperatureRepository repository) {
        this.repository = repository;
    }

    /**
     * Find all temperatures in the database and convert them
     * all to degrees Celsius.
     *
     * @return temperatures in degrees Celsius
     */
    public Flux<Temperature> findAll() {
        return repository.findAll()
                .map(TemperatureConverter::toCelsius)
                .onErrorContinue((t, o) -> System.out.println(t.getMessage()));
    }

    /**
     * Get latest temperature and convert it to degrees
     * Celsius.
     *
     * @return latest temperature in degrees Celsius.
     */
    public Mono<Temperature> getLive() {
        return repository.findAll()
                .sort(Comparator.comparing(Temperature::getTimestamp))
                .map(TemperatureConverter::toCelsius)
                .onErrorContinue((t, o) -> System.out.println(t.getMessage()))
                .last();
    }

}
