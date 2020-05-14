package it.academy.booking.tourist.request;

import lombok.*;

import java.util.Date;
@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarSearch {
    private Long id;
    private Date dateCheck;
    private Date dateReturn;
    private String country;
    private String town;
}
