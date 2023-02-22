package entity;

/**
 * @author stkey
 * @customize
 * @add
 * @components
 * @throws
 * @return
 * @since 22.02.2023
 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ogrenci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 50)
    private String ad;

    @Column(unique = true)
    private long numara;

    @Column(length = 2)
    private long yas;

    @OneToOne
    private Address address;

    public Ogrenci(String ad, long numara, long yas) {
        this.ad = ad;
        this.numara = numara;
        this.yas = yas;
    }
}