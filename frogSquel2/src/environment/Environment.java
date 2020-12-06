package environment;

import java.util.ArrayList;

import gameCommons.Case;
import gameCommons.Game;
import gameCommons.IEnvironment;

public class Environment implements IEnvironment {
    //TODO
    private Game game;
    private ArrayList<Lane> nbOfLanes;

    public Environment(Game game) {
        this.game = game;
        this.lane = new ArrayList<>();

        for (int i = 1; i < game.height - 1; i++) {
            this.lanes.add(new Lane(game, i));
        }
    }
    private ArrayList<Lane> initializeLaneInf(){
        ArrayList<Lane> initialized = new ArrayList<>();
        initialized.add(new Lane(game, 0, 0));
        initialized.add(new Lane(game, 1, 0));

        for(int i = 2; i < this.game.height; i++){
            initialized.add(new Lane(game, i, this.game.defaultDensity));
        }
        return initialized;
    }


    public boolean isSafe(Case c) {
        for (Lane l : this.numberOfLanes) {
            if (l.ord == c.ord)
                return l.isSafe(c);
        }
        return false;
    }

    public boolean isWinningPosition(Case c) {
        return (c.ord == this.game.height - 1);
    }

    public void update() {
        for (Lane l : this.numberOfLanes)
            l.update();
    }
}


