package awsspring.test.domain;

import awsspring.test.domain.Enum.CarBrand;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
public class Car {

    @Id @GeneratedValue
    @Column(name = "car_id")
    private long id;

    private String carName;

    private CarBrand carBrand;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId")
    private User user;

}
