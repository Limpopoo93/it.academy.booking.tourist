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
        (exclude =
                "company"
        )
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "type_car")
    private String typeCar;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "class_car")
    private String classCar;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "name_car")
    private String nameCar;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "make_car")
    private String makeCar;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "col_doors")
    private Integer colDoors;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "col_people")
    private Integer people;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "color")
    private String color;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "col_bag")
    private Integer colBag;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "type_transcriptions")
    private String typeTranscriptions;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "type_engine")
    private String typeEngine;
    @Column(name = "price")
    private Long priceCar;
    @Column(name = "type_fuel")
    private String typeFuel;
    @Column(name = "date_realise")
    private Date dateRealise;
    @Column(name = "created")
    private Date created;
    @Column(name = "updated")
    private Date updated;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_company")
    private Company company;
}
