package nl.quintor.webfluxassignments.controller;

import nl.quintor.webfluxassignments.InvalidTemperatureUnitException;
import nl.quintor.webfluxassignments.model.Temperature;
import nl.quintor.webfluxassignments.service.TemperatureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    private TemperatureService temperatureService;

    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    /**
     * Find all temperatures in the database and return them.
     * @return collection of temperatures from database.
     */
    @GetMapping
    public List<Temperature> findAll() {
        return temperatureService.findAll();
    }

    /**
     * Get the latest (live) temperature in the database.
     * @return latest temperature in database.
     */
    @GetMapping("/live")
    public Temperature getLive() {
        return temperatureService.getLive();
    }


    @ExceptionHandler(InvalidTemperatureUnitException.class)
    public ResponseEntity ExceptionHandler(InvalidTemperatureUnitException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Unprocessable temperature unit in resource");
    }
}
