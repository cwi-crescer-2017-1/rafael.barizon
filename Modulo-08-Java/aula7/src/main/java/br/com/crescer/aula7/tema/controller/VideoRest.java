/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.controller;

import br.com.crescer.aula7.tema.entity.Video;
import br.com.crescer.aula7.tema.service.VideoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Barizon
 */
@RestController
@RequestMapping("/video")
public class VideoRest {
    @Autowired
    private VideoService videoService; 
    
    @GetMapping("/{id}")
    public Video findOne(@PathVariable("id") Long id) {
        return videoService.loadById(id);
    }

    @ResponseBody
    @GetMapping
    public List<Video> findAll() {
        return videoService.findAll();
    }
    
    @PostMapping
    public Video save(@RequestBody Video c){
        return videoService.save(c);
    }
    
    @PostMapping("/{id}")
    public void remove(@RequestBody Video c){
        videoService.remove(c);
    }
    
}