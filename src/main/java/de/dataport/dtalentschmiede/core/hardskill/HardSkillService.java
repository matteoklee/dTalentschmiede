package de.dataport.dtalentschmiede.core.hardskill;

import de.dataport.dtalentschmiede.persistence.hardskill.HardSkillEntity;
import de.dataport.dtalentschmiede.persistence.hardskill.HardSkillPersistenceService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Class "HardSkillService" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Service
public class HardSkillService {

    private final HardSkillPersistenceService hardSkillPersistenceService;

    public HardSkillService(HardSkillPersistenceService hardSkillPersistenceService) {
        this.hardSkillPersistenceService = hardSkillPersistenceService;
    }

    public HardSkill createHardSkill() {
        return new HardSkillImpl(hardSkillPersistenceService.createHardSkillEntity());
    }

    public HardSkill persistHardSkill(@NonNull HardSkill hardSkill) {
        HardSkillEntity persistedHardSkillEntity = hardSkillPersistenceService.persistHardSkill((( HardSkillImpl) hardSkill).getHardSkillEntity());
        return new HardSkillImpl(persistedHardSkillEntity);
    }

    public List<HardSkill> findAllHardSkills() {
        return hardSkillPersistenceService.findAllHardSkills()
                .stream()
                .map(HardSkillImpl::new)
                .collect(Collectors.toList());
    }

    public HardSkill findHardSkillById(long hardSkillId) {
        try {
            return new HardSkillImpl(hardSkillPersistenceService.findHardSkillById(hardSkillId));
        } catch (Exception exception) {
            throw new NoSuchElementException("hardskill with id: " + hardSkillId + " could not be found.");
        }
    }

    public HardSkill updateHardSkill(long hardSkillId, @NonNull HardSkill hardSkill) {
        final HardSkillEntity updatedHardSkillEntity;
        try {
            updatedHardSkillEntity = hardSkillPersistenceService.updateHardSkill(hardSkillId, (( HardSkillImpl) hardSkill).getHardSkillEntity());
        } catch (Exception exception) {
            throw new RuntimeException("hardskill with id: " + hardSkillId + " could not be updated.");
        }
        return new HardSkillImpl(updatedHardSkillEntity);
    }

    public void deleteHardSkill(@NonNull HardSkill hardSkill) {
        hardSkillPersistenceService.deleteHardSkill((( HardSkillImpl) hardSkill).getHardSkillEntity());
    }

    public void deleteHardSkillById(long hardSkillId) {
        hardSkillPersistenceService.deleteHardSkillById(hardSkillId);
    }
}
