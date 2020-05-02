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
@Table(name = "m_photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_photo")
    private String namePhoto;
    @Lob
    @Column(name = "type_photo")
    @Basic(fetch = FetchType.LAZY)
    private byte[] typePhoto;
    @Column
    private Boolean delete;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;
}
