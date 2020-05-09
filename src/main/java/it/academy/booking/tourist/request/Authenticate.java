package it.academy.booking.tourist.request;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "m_authenticate")
public class Authenticate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private Boolean active;
    @Column
    private Boolean acess;
    @Column
    private Boolean delete;
    @JsonManagedReference
    @OneToMany(mappedBy = "authenticate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Role> roles = Collections.emptySet();
}
