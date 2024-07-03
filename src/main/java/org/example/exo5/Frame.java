package org.example.exo5;


import java.util.ArrayList;
import java.util.List;

public class Frame {
    private int score = 0;
    private boolean lastFrame;
    private IGenerateur generateur;
    private List<Roll> rolls;
    int max = 10;

    public Frame(IGenerateur generateur, boolean lastFrame) {
        this.lastFrame = lastFrame;
        this.generateur = generateur;
        this.rolls = new ArrayList<>();
    }

    private void majMax() {
        if (!lastFrame) {
            if (rolls.size() < 2) {
                max = 10 - rolls.get(0).getPins();
            }
        }
    }


public int getScore() {
    return score;
}

public int makeFrame() {
    Roll roll = new Roll();
    int pins = generateur.randomPin(max);
    score += pins;
    roll.setPins(pins);
    rolls.add(roll);
    majMax();
    return pins;
}

public boolean makeRoll() {
    if (!lastFrame) {
        if (score < max && rolls.size() < 2) {
            makeFrame();
            return true;
        }
        return false;
    } else {
        if ((score < max && rolls.size() < 2) || score >= max && rolls.size() < 3) {
            makeFrame();
            return true;
        }
        return false;
    }
}
}

