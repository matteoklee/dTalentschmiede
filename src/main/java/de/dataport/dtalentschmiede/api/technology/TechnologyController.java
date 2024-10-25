package de.dataport.dtalentschmiede.api.technology;

import de.dataport.dtalentschmiede.api.technology.dto.TechnologyRequestDTO;
import de.dataport.dtalentschmiede.api.technology.dto.TechnologyDTO;
import de.dataport.dtalentschmiede.core.technology.Technology;
import de.dataport.dtalentschmiede.core.technology.TechnologyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class "TechnologyController" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@RestController
@RequestMapping("/api/v1/technology")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping
    public ResponseEntity<List<TechnologyDTO>> getAllTechnologys() {
        return ResponseEntity.ok(
                technologyService.findAllTechnologys()
                        .stream()
                        .map(TechnologyDTO::new)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnologyDTO> getTechnologyById(@PathVariable(value = "id") long technologyId) {
        return ResponseEntity.ok(new TechnologyDTO(technologyService.findTechnologyById(technologyId)));
    }

    @PostMapping
    public ResponseEntity<TechnologyDTO> createTechnology(@RequestBody TechnologyRequestDTO technologyRequestDTO) {
        Technology newTechnology = mapToTechnology(technologyRequestDTO);
        Technology persistedTechnology = technologyService.persistTechnology(newTechnology);
        return new ResponseEntity<>(new TechnologyDTO(persistedTechnology), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnologyDTO> updateTechnology(@PathVariable(value = "id") long technologyId, @RequestBody TechnologyRequestDTO technologyRequestDTO) {
        Technology updatedTechnology = mapToTechnology(technologyRequestDTO);
        updatedTechnology.setTechnologyId(technologyId);
        Technology persistedTechnology = technologyService.updateTechnology(technologyId, updatedTechnology);
        return ResponseEntity.ok(new TechnologyDTO(persistedTechnology));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable(value = "id") long technologyId) {
        technologyService.deleteTechnologyById(technologyId);
        return ResponseEntity.noContent().build();
    }

    private Technology mapToTechnology(TechnologyRequestDTO dto) {
        Technology technology = technologyService.createTechnology();
        technology.setTechnologyName(dto.getTechnologyName());
        technology.setTechnologyValue(dto.getTechnologyValue());
        return technology;
    }
}
