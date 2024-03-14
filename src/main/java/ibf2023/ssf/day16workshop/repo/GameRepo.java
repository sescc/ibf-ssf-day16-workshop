package ibf2023.ssf.day16workshop.repo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import ibf2023.ssf.day16workshop.model.Game;
import ibf2023.ssf.day16workshop.util.Util;

@Repository
public class GameRepo {

    @Autowired
    @Qualifier(Util.REDIS_TWO)
    //RedisTemplate template;
    HashOperations<String, Integer, Game> hashOps;

    public void test() {
        //HashOperations hashOps = template.opsForHash();
    }

    // CREATE into redis map
    public void saveGame(Game game) {
        // boolean isSaved = false;
        hashOps.putIfAbsent(Util.KEY_GAME, game.getGameId(), game);
    }
    
    // READ from redis map
    public Map<Integer, Game> getAllGames() {
        return hashOps.entries(Util.KEY_GAME);
    }

    // READ one specific record
    public Game getGameById(String gameId) {
        return hashOps.get(Util.KEY_GAME, gameId);
    }

    // UPDATE specific record into redis map
    public void updateGame(Game game) {
        hashOps.put(Util.KEY_GAME, game.getGameId(), game);
    }

    // DELETE one record from redis map
    public void deleteGame(String gameId) {
        hashOps.delete(Util.KEY_GAME, gameId);
    } 
    
}
