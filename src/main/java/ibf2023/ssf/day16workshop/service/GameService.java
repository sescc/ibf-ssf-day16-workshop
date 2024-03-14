package ibf2023.ssf.day16workshop.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2023.ssf.day16workshop.model.Game;
import ibf2023.ssf.day16workshop.repo.GameRepo;

@Service
public class GameService {
    
    @Autowired
    GameRepo gameRepo;

    public void createGame(Game game) {
        gameRepo.saveGame(game);
    }

    public Map<Integer, Game> getGameList() {
        return gameRepo.getAllGames();
    }

    public Game getGameById(String gameId) {
        return gameRepo.getGameById(gameId);
    }

    public void updateGame(Game game) {
        gameRepo.updateGame(game);
    }

    public void deleteGame(String gameId) {
        gameRepo.deleteGame(gameId);
    }
}
