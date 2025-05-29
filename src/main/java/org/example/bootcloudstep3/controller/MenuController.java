package org.example.bootcloudstep3.controller;

import lombok.RequiredArgsConstructor;
import org.example.bootcloudstep3.dto.MenuDTO;
import org.example.bootcloudstep3.entity.Menu;
import org.example.bootcloudstep3.repository.MenuRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuRepository menuRepository;

    @GetMapping
    public ResponseEntity<List<Menu>> list() {
        return ResponseEntity.ok(menuRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Menu> create(@RequestBody MenuDTO dto) {
        Menu menu = new Menu();
        menu.setName(dto.name());
        menu.setCreatedAt(ZonedDateTime.now(ZoneOffset.UTC));
        return ResponseEntity.status(201).body(menuRepository.save(menu));
    }
}
