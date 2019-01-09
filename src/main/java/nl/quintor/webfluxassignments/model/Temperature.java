package nl.quintor.webfluxassignments.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@ToString
@Getter
@Setter
@Document
public class Temperature {
    private double temperature;
    private Unit unit;
    private LocalDateTime timestamp;
}