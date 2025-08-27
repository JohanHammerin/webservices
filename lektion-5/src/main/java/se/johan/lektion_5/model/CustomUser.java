package se.johan.lektion_5.model;

public record CustomUser(
        int id,
        String username,
        String password,
        boolean isEnabled) {
}
