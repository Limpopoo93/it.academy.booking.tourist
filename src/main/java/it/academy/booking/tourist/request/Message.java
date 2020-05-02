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
@Table(name = "m_message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text_message")
    private String textMessage;
    @Column(name = "date_message")
    private Date dateMessage;
    @Column(name = "delete")
    private Boolean delete;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_authenticate", nullable = false)
    private Authenticate authenticate;
}
