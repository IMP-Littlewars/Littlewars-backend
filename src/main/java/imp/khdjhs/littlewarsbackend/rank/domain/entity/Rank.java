package imp.khdjhs.littlewarsbackend.rank.domain.entity;

import imp.khdjhs.littlewarsbackend.rank.domain.enumerations.Level;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rank {

    @Id
    @GeneratedValue
    @Column(name = "rank_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Level level;

    private String name;

    private int score;

    public Rank(Level level, String name, int score) {
        this.level = level;
        this.name = name;
        this.score = score;
    }
}
