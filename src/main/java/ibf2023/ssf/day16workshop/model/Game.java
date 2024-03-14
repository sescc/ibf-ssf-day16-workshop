package ibf2023.ssf.day16workshop.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;

public class Game {

    private int gameId;

    @NotEmpty(message = "Please enter Home Team name.")
    private String homeTeam;
    
    @NotEmpty(message = "Please enter Away Team name.")
    private String awayTeam;

    private String venue;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date gameDate;
    
    public Game() {
    }

    public Game(String homeTeam, String awayTeam, String venue, Date gameDate) {
        this.gameId = Integer.parseInt(UUID.randomUUID().toString());
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.venue = venue;
        this.gameDate = gameDate;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }
    
    
}
