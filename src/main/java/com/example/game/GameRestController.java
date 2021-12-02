package com.example.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webapi")
public class GameRestController {

    @Autowired
    GameService gameService;

    @GetMapping("/allGames")
    public Iterable<Game> showAllGames() {

        return gameService.queryGames();
    }

    @GetMapping("/getGame/{name}")
    public Game getGame(@PathVariable String name) {
        return gameService.getGameByIndex(gameService.findGameByName(name));
    }

    @PostMapping(path = "/addGame", consumes = "application/json")
    public void insertGame(@RequestBody Game game) {

        gameService.queryAddGame(game);

    }

    @DeleteMapping("/deleteGame/{name}")
    public void deleteGame(@PathVariable String name) {

        if (gameService.findGameByName(name) != -1)
            gameService.queryDeleteGame(name);

    }

    @PutMapping("/updateGame/{name}")
    public void updateGame(@RequestBody Game game, @PathVariable String name) {

        int index = gameService.findGameByName(name);

        if (index != -1) {

            Game gameToReplace = gameService.getGameByIndex(index);

            if (game.getName() != null) gameToReplace.setName(game.getName());
            if (game.getContactAdress() != null) gameToReplace.setContactAdress(game.getContactAdress());
            if (game.getPriceToken() != 0) gameToReplace.setPriceToken(game.getPriceToken());
            if (game.getHolders() != 0) gameToReplace.setHolders(game.getHolders());

            gameService.replaceGame(index,gameToReplace);
        }
    }
}
