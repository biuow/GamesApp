package com.android.alex.alexp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Developer on 17/03/2017.
 */

public class Games {
    private List<Game> games = new ArrayList<>();

    public Games(Game...games){
        for (Game g : games)
            this.games.add(g);
    }
    public Game gamesAddSerie(int jogador){
        Game g;
        for (Game game : games){
            g = game.addSerie(jogador);
            if (g != null) return g;
        }
        return null;
    }
}
