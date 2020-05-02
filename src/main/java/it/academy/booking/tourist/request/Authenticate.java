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
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_passport", nullable = false)
    private Passport passport;
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_personal_info", nullable = false)
    private PersonalInformation personalInfo;
    @JsonManagedReference
    @OneToMany(mappedBy = "authenticate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Role> roles = Collections.emptySet();
}
