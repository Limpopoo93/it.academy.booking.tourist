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
@Table(name = "m_photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Valid
    @NotEmpty
    @NotNull
    @Size(max = 10, min = 10)
    @Column(name = "name_photo")
    private String namePhoto;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "type_photo")
    private byte[] typePhoto;
    @Column(name = "created")
    private Date created;
    @Column(name = "updated")
    private Date updated;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_car")
    private Car car;
}
