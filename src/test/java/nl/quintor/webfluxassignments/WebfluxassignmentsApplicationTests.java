package nl.quintor.webfluxassignments;

import nl.quintor.webfluxassignments.model.Temperature;
import nl.quintor.webfluxassignments.model.Unit;
import nl.quintor.webfluxassignments.repository.TemperatureRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class WebfluxassignmentsApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TemperatureRepository repository;

    @Before
    public void setupDatabase() {
        repository.deleteAll();

        var dummyTemperature = Arrays.asList(
                Temperature.builder().temperature(12.01).unit(Unit.CELSIUS).timestamp(LocalDateTime.now()).build(),
                Temperature.builder().temperature(26.21).unit(Unit.FAHRENHEIT).timestamp(LocalDateTime.now()).build(),
                Temperature.builder().temperature(13.81).unit(Unit.CELSIUS).timestamp(LocalDateTime.now()).build()
        );

        repository.saveAll(dummyTemperature);

    }

    @Test
    public void findAll() {
        var reponse = restTemplate.getForEntity("http://localhost:"+ port+"/temperature", Temperature[].class);

        assertThat(reponse.getStatusCode(), is(HttpStatus.OK));
        assertThat(reponse.getBody().length, is(3));
    }

    @Test
    public void findAllFail() {
        repository.save(Temperature.builder().temperature(12).timestamp(LocalDateTime.now()).build());

        var reponse = restTemplate.getForEntity("http://localhost:"+ port+"/temperature", String.class);

        assertThat(reponse.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(reponse.getBody(), is("Unprocessable temperature unit in resource"));
    }

    @Test
    public void getLive() {
        var timestamp = LocalDateTime.of(LocalDate.now().getYear() + 1, 1, 1, 1, 1);
        var temp = Temperature.builder().temperature(12).unit(Unit.CELSIUS).timestamp(timestamp).build();
        repository.save(temp);

        var reponse = restTemplate.getForEntity("http://localhost:"+ port+"/temperature/live", Temperature.class);

        assertThat(reponse.getStatusCode(), is(HttpStatus.OK));
        assertThat(reponse.getBody(), is(temp));
    }

    @Test
    public void getLiveFail() {
        repository.save(Temperature.builder().temperature(12).timestamp(LocalDateTime.now()).build());

        var reponse = restTemplate.getForEntity("http://localhost:"+ port+"/temperature", String.class);

        assertThat(reponse.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
        assertThat(reponse.getBody(), is("Unprocessable temperature unit in resource"));
    }
}

