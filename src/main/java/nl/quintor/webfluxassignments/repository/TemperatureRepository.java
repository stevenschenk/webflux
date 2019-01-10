package nl.quintor.webfluxassignments.repository;

import nl.quintor.webfluxassignments.model.Temperature;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends ReactiveMongoRepository<Temperature, Long> {
}
