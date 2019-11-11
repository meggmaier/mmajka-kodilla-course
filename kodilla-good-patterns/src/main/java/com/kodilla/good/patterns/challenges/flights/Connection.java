package com.kodilla.good.patterns.challenges.flights;


import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Connection {

    Airport home;
    Airport destination;

}
