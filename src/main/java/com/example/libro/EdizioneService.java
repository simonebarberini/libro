package com.example.libro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdizioneService {
    
    @Autowired
    private EdizioneRepository edizioneRepository;

    public List<Edizione>findAll(){
        return edizioneRepository.findAll();
    }

    public Optional<Edizione> findById(Long id) {
        return edizioneRepository.findById(id);
    }

    public Edizione save(Edizione edizione) {
        return edizioneRepository.save(edizione);
    }

    public void deleteById(Long id) {
        edizioneRepository.deleteById(id);
    }
}
