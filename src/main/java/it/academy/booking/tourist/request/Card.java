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
@Table(name = "m_card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type_card")
    private String typeCard;
    @Column
    private Integer usd;
    @Column(name = "keys_number")
    private Integer keyNumber;
    @Column(name = "date_return")
    private Date dateReturn;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Boolean delete;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_authenticate", nullable = false)
    private Authenticate authenticate;
}
