package imp.khdjhs.littlewarsbackend.rank.presentation;

import imp.khdjhs.littlewarsbackend.rank.application.RankService;
import imp.khdjhs.littlewarsbackend.rank.domain.enumerations.Level;
import imp.khdjhs.littlewarsbackend.rank.dto.RankResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/rank/")
public class RankController {

    private final RankService rankService;

    @GetMapping("top")
    public ResponseEntity<RankResponse> top() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(rankService.top());
    }

    @PutMapping("recode")
    public ResponseEntity<RankResponse> recode(
            @RequestParam("level")Level level,
            @RequestParam("name")String name,
            @RequestParam("score")int score) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(rankService.recode(level, name, score));
    }

    @PutMapping("adminSet")
    public ResponseEntity<RankResponse> setRank() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(rankService.setRank());
    }

    @DeleteMapping("adminReset")
    public ResponseEntity<RankResponse> resetRank() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(rankService.resetRank());
    }
}
