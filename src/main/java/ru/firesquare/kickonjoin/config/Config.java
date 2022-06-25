package ru.firesquare.kickonjoin.config;

import redempt.redlib.config.annotations.Comment;
import redempt.redlib.config.annotations.ConfigMappable;

@ConfigMappable
public class Config {
    @Comment("Message")
    public static String message = "You need {role} role to play on this server.";

    @Comment("Role")
    public static String role = "vanilla-player";
}
