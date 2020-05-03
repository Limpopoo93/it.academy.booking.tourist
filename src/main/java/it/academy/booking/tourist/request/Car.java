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
@Table(name = "m_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "type_car")
    private TypeCar typeCar;
    @Enumerated(EnumType.STRING)
    @Column(name = "class_car")
    private ClassCar classCar;
    @Column(name = "name_car")
    private String name;
    @Column(name = "make_car")
    private String make;
    @Column(name = "col_doors")
    private Integer colDoors;
    @Column(name = "col_people")
    private Integer colPeople;
    @Column
    private String color;
    @Column(name = "col_bag")
    private Integer colBag;
    @Enumerated(EnumType.STRING)
    @Column(name = "type_transmission")
    private TypeTransmission typeTransmission;
    @Column(name = "type_engine")
    private String typeEngine;
    @Enumerated(EnumType.STRING)
    @Column(name = "type_fuel")
    private TypeFuel typeFuel;
    @Column(name = "date_realise")
    private Date dateRealise;
    @Column
    private Boolean delete;
}
