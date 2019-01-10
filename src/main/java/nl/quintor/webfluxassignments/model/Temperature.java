package nl.quintor.webfluxassignments.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@ToString
@EqualsAndHashCode
@Getter
@Setter
@Builder
@Document
public class Temperature {
    private double temperature;
    private Unit unit;
    private LocalDateTime timestamp;
}