package com.oogie.discographyrest.controller;

import com.oogie.discographyrest.SongListRepository;
import com.oogie.discographyrest.model.SongListEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongListController {
    private final SongListRepository repository;

    SongListController(SongListRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/songlist")
    List<SongListEntity> all() {
        return repository.findAll();
    }

    @PostMapping("/songlist")
    SongListEntity newSongList(@RequestBody SongListEntity nuSongList) {
        return repository.save(nuSongList);
    }

    // Single Item

    @GetMapping("/songlist/{id}")
    SongListEntity one(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new SongNotFoundException(id));
    }

    @PutMapping("/songlist/{id}")
    SongListEntity replaceSonglist(@RequestBody SongListEntity nuSongList, @PathVariable Integer id) {
        return repository.findById(id).map(songlist -> {
            songlist.setSongName(nuSongList.getSongName());
            songlist.setMusician(nuSongList.getMusician());
            songlist.setYear(nuSongList.getYear());
            songlist.setAlbum(nuSongList.getAlbum());
            songlist.setGenre(nuSongList.getGenre());
            return repository.save(songlist);
        }).orElseGet(() -> {
            nuSongList.setId(id);
            return repository.save(nuSongList);
        });
    }

    @DeleteMapping("/songlist/{id}")
    void deleteSonglist(@PathVariable Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
//            Error error =
        }
    }
}
