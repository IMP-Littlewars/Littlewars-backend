package imp.khdjhs.littlewarsbackend.rank.domain.repository;

import imp.khdjhs.littlewarsbackend.rank.domain.entity.Rank;
import imp.khdjhs.littlewarsbackend.rank.domain.enumerations.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RankRepository extends JpaRepository<Rank, Long> {

    List<Rank> findRankByLevel(Level level);

    List<Rank> findTop5ByLevelOrderByScoreAsc(Level level);
}
