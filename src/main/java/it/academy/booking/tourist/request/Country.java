package it.academy.booking.tourist.request;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_country")
    private String nameCountry;
    @Column
    private Integer reting;
    @Column
    private Boolean delete;
}
