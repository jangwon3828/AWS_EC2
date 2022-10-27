package awsspring.test.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import static javax.persistence.GenerationType.IDENTITY;
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private long id;

    private String username;

    @Max(value = 150)
    @Min(value = 0)
    private int age;

    @Builder
    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
