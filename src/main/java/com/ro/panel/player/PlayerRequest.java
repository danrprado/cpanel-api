package com.ro.panel.player;

public record PlayerRequest(
        String email,
        String name,
        String password,
        Integer pin_code
        ){
}

