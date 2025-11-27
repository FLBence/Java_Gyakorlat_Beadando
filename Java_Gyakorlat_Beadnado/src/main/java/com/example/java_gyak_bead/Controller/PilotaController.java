package com.example.java_gyak_bead.Controller;

import com.example.java_gyak_bead.Repository.PilotaRepository;
import com.example.java_gyak_bead.model.Pilota;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pilots")
@CrossOrigin(origins = "*")
public class PilotaController {

    private final PilotaRepository repo;

    public PilotaController(PilotaRepository repo) {
        this.repo = repo;
    }

    // GET - összes pilóta
    @GetMapping
    public List<Pilota> getAll() {
        return repo.findAll();
    }

    // GET - egy pilóta id alapján
    @GetMapping("/{id}")
    public Pilota getById(@PathVariable Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Nincs ilyen pilóta: " + id));
    }

    // POST - új pilóta
    @PostMapping
    public Pilota create(@RequestBody Pilota pilot) {
        return repo.save(pilot);
    }

    // PUT - pilóta módosítása
    @PutMapping("/{id}")
    public Pilota update(@PathVariable Integer id, @RequestBody Pilota newData) {
        return repo.findById(id)
                .map(p -> {
                    p.setNev(newData.getNev());
                    p.setNem(newData.getNem());
                    p.setSzuldat(newData.getSzuldat());
                    p.setNemzet(newData.getNemzet());
                    return repo.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Nincs ilyen pilóta: " + id));
    }

    // DELETE - pilóta törlése
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
