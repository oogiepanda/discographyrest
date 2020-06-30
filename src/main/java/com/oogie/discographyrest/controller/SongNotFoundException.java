package com.oogie.discographyrest.controller;

public class SongNotFoundException extends RuntimeException{
    SongNotFoundException(Integer id) {
        super("Could not find songlist " + id);
    }
}
