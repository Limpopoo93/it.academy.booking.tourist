package it.academy.booking.tourist.request;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_company")
    private String name;
    @Column
    private Integer reting;
    @Column
    private String street;
    @Column(name = "number_street")
    private Integer numberStreet;
    @Column
    private String telephone;
    @Column
    private String email;
    @Column
    private Boolean delete;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_town", nullable = false)
    private Town town;
    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_authenticate", nullable = false)
    private Authenticate authenticate;
}
