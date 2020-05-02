package it.academy.booking.tourist.request;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String country;
    @Column
    private String town;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(name = "middlename")
    private String middleName;
    @Column(name = "date_user")
    private Date dateUser;
    @Column(name = "number_passport")
    private String numberPassport;
    @Column(name = "indeficial_passport")
    private String indeficialPassport;
    @Column
    private Boolean delete;
}
