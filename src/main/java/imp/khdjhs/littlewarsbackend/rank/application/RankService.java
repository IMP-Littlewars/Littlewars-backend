package imp.khdjhs.littlewarsbackend.rank.application;

import imp.khdjhs.littlewarsbackend.rank.domain.entity.Rank;
import imp.khdjhs.littlewarsbackend.rank.domain.enumerations.Level;
import imp.khdjhs.littlewarsbackend.rank.domain.repository.RankRepository;
import imp.khdjhs.littlewarsbackend.rank.dto.LevelResponse;
import imp.khdjhs.littlewarsbackend.rank.dto.RankResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class  RankService {

    private final RankRepository rankRepository;

    public RankResponse top() {

        RankResponse rankResponse = new RankResponse(
                true, new ArrayList<>(), new ArrayList<>(), new ArrayList<>() );

        List<Rank> easyRank   = rankRepository.findTop5ByLevelOrderByScoreAsc(Level.EASY);
        List<Rank> normalRank = rankRepository.findTop5ByLevelOrderByScoreAsc(Level.NORMAL);
        List<Rank> hardRank   = rankRepository.findTop5ByLevelOrderByScoreAsc(Level.HARD);

        List<LevelResponse> easy = new ArrayList<>();
        List<LevelResponse> normal = new ArrayList<>();
        List<LevelResponse> hard = new ArrayList<>();

        for (Rank e : easyRank)
            easy.add(new LevelResponse(e.getName(), e.getScore()));
        for (Rank e : normalRank)
            normal.add(new LevelResponse(e.getName(), e.getScore()));
        for (Rank e : hardRank)
            hard.add(new LevelResponse(e.getName(), e.getScore()));

        rankResponse.setEasy(easy);
        rankResponse.setNormal(normal);
        rankResponse.setHard(hard);

        return rankResponse;
    }

    public RankResponse recode(Level level, String name, int score) {

        Rank rank = new Rank(level, name, score);
        rankRepository.save(rank);

        return new RankResponse(true, null, null,null);

    }

    public RankResponse setRank() {

        List<Rank> rank = new ArrayList<>();

        rank.add(new Rank(Level.EASY, "AAA", 500));
        rank.add(new Rank(Level.EASY, "BBB", 510));
        rank.add(new Rank(Level.EASY, "CCC", 520));
        rank.add(new Rank(Level.EASY, "DDD", 530));
        rank.add(new Rank(Level.EASY, "EEE", 540));

        rank.add(new Rank(Level.NORMAL, "FFF", 600));
        rank.add(new Rank(Level.NORMAL, "GGG", 610));
        rank.add(new Rank(Level.NORMAL, "HHH", 620));
        rank.add(new Rank(Level.NORMAL, "III", 630));
        rank.add(new Rank(Level.NORMAL, "JJJ", 640));

        rank.add(new Rank(Level.HARD, "KKK", 700));
        rank.add(new Rank(Level.HARD, "LLL", 710));
        rank.add(new Rank(Level.HARD, "MMM", 720));
        rank.add(new Rank(Level.HARD, "NNN", 730));
        rank.add(new Rank(Level.HARD, "OOO", 740));

        rankRepository.saveAll(rank);

        return new RankResponse(true, null, null, null);
    }

    public RankResponse resetRank() {

        rankRepository.deleteAll();

        return new RankResponse(true, null, null, null);
    }
}
