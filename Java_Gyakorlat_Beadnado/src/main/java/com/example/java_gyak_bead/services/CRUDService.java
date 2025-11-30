package com.example.java_gyak_bead.services;

import com.example.java_gyak_bead.model.Pilota;
import com.example.java_gyak_bead.repository.PilotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CRUDService {

    private final PilotaRepository repo;

    public CRUDService(PilotaRepository repo) {
        this.repo = repo;
    }

    public List<Pilota> getall() {
        return repo.findAll();
    }

    public Optional<Pilota> getone(Integer id) {
        return repo.findById(id);
    }

    public Pilota save(Pilota pilota) {
        if (repo.existsById(pilota.getId())) {
            throw new IllegalArgumentException("Már létezik ilyen ID: " + pilota.getId());
        }
        return repo.save(pilota);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public void update(Integer id, Pilota mod) {
        repo.findById(id).ifPresent(p -> {
            p.setNev(mod.getNev());
            p.setNem(mod.getNem());
            p.setSzuldat(mod.getSzuldat());
            p.setNemzet(mod.getNemzet());
            repo.save(p);
        });
    }

}
