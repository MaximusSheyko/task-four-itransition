package org.example.core;

public enum StatusWinners {
        PLAYER_WIN("Player is win!"),
        AI_WIN("Ai is win!"),
        TIE("Tie!");

    private final String status;

    StatusWinners(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
