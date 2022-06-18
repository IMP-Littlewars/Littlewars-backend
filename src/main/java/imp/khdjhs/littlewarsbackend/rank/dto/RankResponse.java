package imp.khdjhs.littlewarsbackend.rank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RankResponse {

    private Boolean signal;

    private List<LevelResponse> easy;

    private List<LevelResponse> normal;

    private List<LevelResponse> hard;
}
