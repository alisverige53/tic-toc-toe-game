package src;

import java.util.Random;

public class Player {

    private final String name;
    private final String marker;

    public Player(String name, String marker) {
        this.name = name;
        this.marker = marker;
    }

    public String getName() {
        return name;
    }

    public String getMarker() {
        return marker;
    }

    public static Player chooseStartingPlayer(Player player1, Player player2) {
        return new Random().nextBoolean() ? player1 : player2;
    }
}
