package org.example.MusicBands;

public enum Color {
    GREEN,
    BLUE,
    ORANGE,
    WHITE;

    public static void colors() {
        for (var i : Color.values()){
            System.out.println(i);
        }
    }
}
