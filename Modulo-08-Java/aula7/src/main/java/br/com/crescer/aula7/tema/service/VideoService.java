/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.tema.service;

import br.com.crescer.aula7.tema.repository.VideoRepository;
import br.com.crescer.aula7.tema.entity.Video;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Barizon
 */
@Service
public class VideoService implements GenericService<Video, Long>{
    
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video save(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public void remove(Video video) {
        videoRepository.delete(video);
    }

    @Override
    public Video loadById(Long id) {
        return videoRepository.findOne(id);
    }

    @Override
    public List<Video> findAll() {
        return (List<Video>) videoRepository.findAll();
    }
    
}
