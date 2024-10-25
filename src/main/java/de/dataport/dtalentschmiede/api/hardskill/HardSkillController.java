package de.dataport.dtalentschmiede.api.hardskill;

import de.dataport.dtalentschmiede.api.hardskill.dto.HardSkillDTO;
import de.dataport.dtalentschmiede.api.hardskill.dto.HardSkillRequestDTO;
import de.dataport.dtalentschmiede.core.hardskill.HardSkill;
import de.dataport.dtalentschmiede.core.hardskill.HardSkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class "HardSkillController" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@RestController
@RequestMapping("/api/v1/hardskill")
public class HardSkillController {

    private final HardSkillService hardSkillService;

    public HardSkillController(HardSkillService hardSkillService) {
        this.hardSkillService = hardSkillService;
    }

    @GetMapping
    public ResponseEntity<List<HardSkillDTO>> getAllHardSkills() {
        return ResponseEntity.ok(
                hardSkillService.findAllHardSkills()
                        .stream()
                        .map(HardSkillDTO::new)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardSkillDTO> getHardSkillById(@PathVariable(value = "id") long hardSkillId) {
        return ResponseEntity.ok(new HardSkillDTO(hardSkillService.findHardSkillById(hardSkillId)));
    }

    @PostMapping
    public ResponseEntity<HardSkillDTO> createHardSkill(@RequestBody HardSkillRequestDTO hardSkillRequestDTO) {
        HardSkill newHardSkill = mapToHardSkill(hardSkillRequestDTO);
        HardSkill persistedHardSkill = hardSkillService.persistHardSkill(newHardSkill);
        return new ResponseEntity<>(new HardSkillDTO(persistedHardSkill), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HardSkillDTO> updateHardSkill(@PathVariable(value = "id") long hardSkillId, @RequestBody HardSkillRequestDTO hardSkillRequestDTO) {
        HardSkill updatedHardSkill = mapToHardSkill(hardSkillRequestDTO);
        updatedHardSkill.setHardSkillId(hardSkillId);
        HardSkill persistedHardSkill = hardSkillService.updateHardSkill(hardSkillId, updatedHardSkill);
        return ResponseEntity.ok(new HardSkillDTO(persistedHardSkill));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHardSkill(@PathVariable(value = "id") long hardSkillId) {
        hardSkillService.deleteHardSkillById(hardSkillId);
        return ResponseEntity.noContent().build();
    }

    private HardSkill mapToHardSkill(HardSkillRequestDTO dto) {
        HardSkill hardSkill = hardSkillService.createHardSkill();
        hardSkill.setHardSkillName(dto.getHardSkillName());
        hardSkill.setHardSkillValue(dto.getHardSkillValue());
        return hardSkill;
    }
}
