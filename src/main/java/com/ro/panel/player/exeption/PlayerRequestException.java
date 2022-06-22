package com.ro.panel.player.exeption;

public class PlayerRequestException extends RuntimeException{

    public PlayerRequestException(String message) {
        super(message);
    }

    public PlayerRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}
