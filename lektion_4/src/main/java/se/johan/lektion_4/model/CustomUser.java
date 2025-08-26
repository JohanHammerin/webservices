package se.johan.lektion_4.model;

// Objekt som kan bli en one-liner
public record CustomUser(int id,
                         String username,
                         String password,
                         boolean accountEnabled
) {

}
