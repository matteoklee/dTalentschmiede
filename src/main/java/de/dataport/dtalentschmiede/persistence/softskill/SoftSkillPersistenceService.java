package de.dataport.dtalentschmiede.persistence.softskill;

import jakarta.persistence.EntityExistsException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class "SoftSkillPersistenceService" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Service
public class SoftSkillPersistenceService {

    private final SoftSkillRepository softSkillRepository;

    public SoftSkillPersistenceService(SoftSkillRepository softSkillRepository) {
        this.softSkillRepository = softSkillRepository;
    }

    public SoftSkillEntity createSoftSkillEntity() {
        return new SoftSkillEntity();
    }

    public List<SoftSkillEntity> findAllSoftSkills() {
        return new ArrayList<>(softSkillRepository.findAll());
    }

    public SoftSkillEntity findSoftSkillById(long softSkillId) {
        return softSkillRepository.findById(softSkillId)
                .orElseThrow(() -> new NoSuchElementException("unknown softskill entity with id: " + softSkillId));
    }

    public SoftSkillEntity updateSoftSkill(long softSkillId, @NonNull SoftSkillEntity softSkillEntity) {
        SoftSkillEntity updatedSoftSkillEntity = findSoftSkillById(softSkillId);
        updatedSoftSkillEntity.setSoftSkillId(softSkillEntity.getSoftSkillId());
        updatedSoftSkillEntity.setSoftSkillName(softSkillEntity.getSoftSkillName());
        updatedSoftSkillEntity.setSoftSkillValue(softSkillEntity.getSoftSkillValue());
        return persistSoftSkill(updatedSoftSkillEntity);
    }

    public SoftSkillEntity persistSoftSkill(@NonNull final SoftSkillEntity softSkillEntity) {
        try {
            return softSkillRepository.save(softSkillEntity);
        } catch (EntityExistsException exception) {
            throw new EntityExistsException("softskillentity with id:" + softSkillEntity.getSoftSkillId() + " already exists.");
        }
    }

    public void deleteSoftSkill(@NonNull final SoftSkillEntity softSkillEntity) {
        softSkillRepository.deleteById(softSkillEntity.getSoftSkillId());
    }

    public void deleteSoftSkillById(long softSkillId) {
        softSkillRepository.deleteById(softSkillId);
    }
}
