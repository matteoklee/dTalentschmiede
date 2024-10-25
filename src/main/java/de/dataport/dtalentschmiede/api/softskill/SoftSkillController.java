package de.dataport.dtalentschmiede.api.softskill;

import de.dataport.dtalentschmiede.api.softskill.dto.SoftSkillDTO;
import de.dataport.dtalentschmiede.api.softskill.dto.SoftSkillRequestDTO;
import de.dataport.dtalentschmiede.core.softskill.SoftSkill;
import de.dataport.dtalentschmiede.core.softskill.SoftSkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class "SoftSkillController" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@RestController
@RequestMapping("/api/v1/soft-skill")
public class SoftSkillController {

    private final SoftSkillService softSkillService;

    public SoftSkillController(SoftSkillService softSkillService) {
        this.softSkillService = softSkillService;
    }

    @GetMapping
    public ResponseEntity<List<SoftSkillDTO>> getAllSoftSkills() {
        return ResponseEntity.ok(
                softSkillService.findAllSoftSkills()
                        .stream()
                        .map(SoftSkillDTO::new)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoftSkillDTO> getSoftSkillById(@PathVariable(value = "id") long softSkillId) {
        return ResponseEntity.ok(new SoftSkillDTO(softSkillService.findSoftSkillById(softSkillId)));
    }

    @PostMapping
    public ResponseEntity<SoftSkillDTO> createSoftSkill(@RequestBody SoftSkillRequestDTO softSkillRequestDTO) {
        SoftSkill newSoftSkill = mapToSoftSkill(softSkillRequestDTO);
        SoftSkill persistedSoftSkill = softSkillService.persistSoftSkill(newSoftSkill);
        return new ResponseEntity<>(new SoftSkillDTO(persistedSoftSkill), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SoftSkillDTO> updateSoftSkill(@PathVariable(value = "id") long softSkillId, @RequestBody SoftSkillRequestDTO softSkillRequestDTO) {
        SoftSkill updatedSoftSkill = mapToSoftSkill(softSkillRequestDTO);
        updatedSoftSkill.setSoftSkillId(softSkillId);
        SoftSkill persistedSoftSkill = softSkillService.updateSoftSkill(softSkillId, updatedSoftSkill);
        return ResponseEntity.ok(new SoftSkillDTO(persistedSoftSkill));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSoftSkill(@PathVariable(value = "id") long softSkillId) {
        softSkillService.deleteSoftSkillById(softSkillId);
        return ResponseEntity.noContent().build();
    }

    private SoftSkill mapToSoftSkill(SoftSkillRequestDTO dto) {
        SoftSkill softSkill = softSkillService.createSoftSkill();
        softSkill.setSoftSkillName(dto.getSoftSkillName());
        softSkill.setSoftSkillValue(dto.getSoftSkillValue());
        return softSkill;
    }
}

