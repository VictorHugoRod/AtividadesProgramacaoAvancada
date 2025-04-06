package com.unicesumar.entities;

import java.util.UUID;

public class User {
    private UUID uuid;
    private String name;
    private String email;
    private String password;

    public User(UUID uuid, String name, String email, String password) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this(UUID.randomUUID(), name, email, password);
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", name, email);
    }
}
