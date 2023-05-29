package org.example;

public enum CardValues {
    ACE(11),
    KING(4),
    QUEEN(3),
    JACK(2),
    TEN(10),
    NINE(9),
    EIGHT(8),
    Seven(7),
    Six(6);

    private int data;

    CardValues(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
