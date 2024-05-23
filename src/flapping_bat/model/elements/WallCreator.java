package flapping_bat.model.elements;

import flapping_bat.GUI.LanternaTextGUI;

import java.util.Random;

public class WallCreator {
    private final static int margin = 5;
    private final Random random;

    public WallCreator(){
        this.random = new Random();
    }
    public Wall create(){
        int randomHeight = random.nextInt((LanternaTextGUI.height - margin) / 2) + margin;
        return new Wall(randomHeight);
    }
}
