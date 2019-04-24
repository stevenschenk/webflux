package nl.quintor.webfluxassignments.repository;

import nl.quintor.webfluxassignments.model.Temperature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends MongoRepository<Temperature, Long> {
}
