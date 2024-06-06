package com.example.libro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/edizione")
public class EdizioneController {
    @Autowired
    private EdizioneService edizioneService;

    @GetMapping
    public List<Edizione> getAllLibri() {
        return edizioneService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Edizione> getedizioneById(@PathVariable Long id) {
        Optional<Edizione> edizione = edizioneService.findById(id);
        if (edizione.isPresent()) {
            return ResponseEntity.ok(edizione.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Edizione createedizione(@RequestBody Edizione edizione) {
        return edizioneService.save(edizione);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Edizione> updateEdizione(@PathVariable Long id, @RequestBody Edizione edizioneDetails) {
        Optional<Edizione> edizioneOptional = edizioneService.findById(id);
        if (edizioneOptional.isPresent()) {
            Edizione edizione = edizioneOptional.get();
            edizione.setNomeEdizione(edizioneDetails.getNomeEdizione());
            return ResponseEntity.ok(edizioneService.save(edizione));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteedizione(@PathVariable Long id) {
        Optional<Edizione> edizione = edizioneService.findById(id);
        if (edizione.isPresent()) {
            edizioneService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
