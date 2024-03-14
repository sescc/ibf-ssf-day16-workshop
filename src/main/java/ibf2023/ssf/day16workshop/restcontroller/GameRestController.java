package ibf2023.ssf.day16workshop.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2023.ssf.day16workshop.model.Game;
import ibf2023.ssf.day16workshop.service.GameService;

@RestController
@RequestMapping("/api/games")
public class GameRestController {

    @Autowired
    GameService gameService;

    // CREATE
    @PostMapping("path")
    public ResponseEntity<String> postMethodNameGame(@RequestBody Game requestPayload) {
        gameService.createGame(requestPayload);

        // modify as necessary to fit Day16 Workshop task 1
        return ResponseEntity.ok("Game created successfully.");
    }

    // READ - get all; GetMappig
    @GetMapping("")
    public ResponseEntity<List<Game>> getAllGames() {
        Map<Integer, Game> games = gameService.getGameList();
        List<Game> gameList = new ArrayList<>();

        for (Map.Entry<Integer, Game> game: games.entrySet()) {
            gameList.add(game.getValue());
        }

        return ResponseEntity.ok().body(gameList);
    }

    // READ - GET BY ID; Get Mapping

    // UPDATE; Put Mapping

    // DELETE; deleteMapping
    
}
