package me.yiyi1234.smilelabxmas.core;


import org.bukkit.entity.Player;

public class XMasPlayer {
    private State currState;
    private int points;
    public XMasPlayer() {
        this(0,State.IDLE);
    }

    public XMasPlayer(int points, State state) {
        this.currState = state;
        this.points = points;

    }

    public enum State {
        IDLE, Activity1, Activity2, Activity3
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public State getCurrState() {
        return currState;
    }

    public void setCurrState(State currState) {
        this.currState = currState;
    }
}
