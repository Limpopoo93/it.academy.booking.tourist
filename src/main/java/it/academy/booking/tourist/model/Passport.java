package it.academy.booking.tourist.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_passport")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "country")
    private String country;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "town")
    private String town;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "name")
    private String name;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "surname")
    private String surname;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "date_user")
    private Date dateUser;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "number_passport")
    private String numberPassport;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "indifical_passport")
    private String indificalPassport;
    @Column(name = "created")
    private Date created;
    @Column(name = "updated")
    private Date updated;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
}
