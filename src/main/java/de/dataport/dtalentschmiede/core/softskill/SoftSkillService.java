package de.dataport.dtalentschmiede.core.softskill;

import de.dataport.dtalentschmiede.persistence.softskill.SoftSkillEntity;
import de.dataport.dtalentschmiede.persistence.softskill.SoftSkillPersistenceService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Class "SoftSkillService" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Service
public class SoftSkillService {

    private final SoftSkillPersistenceService softSkillPersistenceService;

    public SoftSkillService(SoftSkillPersistenceService softSkillPersistenceService) {
        this.softSkillPersistenceService = softSkillPersistenceService;
    }

    public SoftSkill createSoftSkill() {
        return new SoftSkillImpl(softSkillPersistenceService.createSoftSkillEntity());
    }

    public SoftSkill persistSoftSkill(@NonNull SoftSkill softSkill) {
        SoftSkillEntity persistedSoftSkillEntity = softSkillPersistenceService.persistSoftSkill((( SoftSkillImpl) softSkill).getSoftSkillEntity());
        return new SoftSkillImpl(persistedSoftSkillEntity);
    }

    public List<SoftSkill> findAllSoftSkills() {
        return softSkillPersistenceService.findAllSoftSkills()
                .stream()
                .map(SoftSkillImpl::new)
                .collect(Collectors.toList());
    }

    public SoftSkill findSoftSkillById(long softSkillId) {
        try {
            return new SoftSkillImpl(softSkillPersistenceService.findSoftSkillById(softSkillId));
        } catch (Exception exception) {
            throw new NoSuchElementException("softskill with id: " + softSkillId + " could not be found.");
        }
    }

    public SoftSkill updateSoftSkill(long softSkillId, @NonNull SoftSkill softSkill) {
        final SoftSkillEntity updatedSoftSkillEntity;
        try {
            updatedSoftSkillEntity = softSkillPersistenceService.updateSoftSkill(softSkillId, (( SoftSkillImpl) softSkill).getSoftSkillEntity());
        } catch (Exception exception) {
            throw new RuntimeException("softskill with id: " + softSkillId + " could not be updated.");
        }
        return new SoftSkillImpl(updatedSoftSkillEntity);
    }

    public void deleteSoftSkill(@NonNull SoftSkill softSkill) {
        softSkillPersistenceService.deleteSoftSkill((( SoftSkillImpl) softSkill).getSoftSkillEntity());
    }

    public void deleteSoftSkillById(long softSkillId) {
        softSkillPersistenceService.deleteSoftSkillById(softSkillId);
    }
}
