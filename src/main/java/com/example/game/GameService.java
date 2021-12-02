package com.example.game;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Service
public class GameService {
    static List<Game> games = new ArrayList<Game>();
    static List<Game> fakegames = new ArrayList<Game>();

    static {
        Game game1 = new Game("Block Farm Club", "0x727b531038198e27a1a4d0fd83e1693c1da94892", 1, 5000, "BFC");
        Game game2 = new Game("Surviving soldiers", "0xa0c8c80ed6b7f09f885e826386440b2349f0da7e", 16, 40000, "SSG");
        Game game3 = new Game("Criptomines", "0x727b531038198e27a1a4d0fd83e1693c1da94892", 54, 88000, "ETERNAL");
        Game game4 = new Game("Coin to fish", "0x55e00121241d6870324a8e6dffaabbe2e0359863", 3, 15000, "CTFT");
        games.add(game1);
        games.add(game2);
        games.add(game3);
        games.add(game4);
    }

    public List<Game> queryGames() {
        return games;
    }

    public List<Game> queryFakeGames() {

        int i = 0;
        Faker newfakegame = new Faker();

        while (i < 10000) {

            String author = newfakegame.book().author();
            String genre = newfakegame.book().genre();
            String title = newfakegame.book().title();

            fakegames.add(new Game(title, genre, getRandomNumber(100, 1250), getRandomNumber(1800, 2021), author));
            i++;
        }

        return fakegames;
    }

    public List<Game> queryDeleteGame(String name) {

        for (Game gameInArray : this.games) {

            if (gameInArray.getName().equals(name)) {
                this.games.remove(gameInArray);
                break;
            }
        }
        return games;
    }

    public int findGameByName(String name) {

        int index = -1;

        for (Game gameInArray : this.games) {
            if (gameInArray.getName().equals(name)) {
                index = this.games.indexOf(gameInArray);
            }
        }
        return index;
    }

    public Game getGameByIndex(int index) {

        Game game = this.games.get(index);

        return game;
    }

    public boolean queryAddGame(Game newgametoadd) {

        this.games.add(newgametoadd);

        return true;

    }

    public void replaceGame(int index, Game game) {

        this.games.set(index, game);

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


}
