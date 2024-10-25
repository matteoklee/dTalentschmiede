package de.dataport.dtalentschmiede.persistence.hardskill;

import jakarta.persistence.EntityExistsException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class "HardSkillPersistenceService" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 25.10.2024
 */
@Service
public class HardSkillPersistenceService {

    private final HardSkillRepository hardSkillRepository;

    public HardSkillPersistenceService(HardSkillRepository hardSkillRepository) {
        this.hardSkillRepository = hardSkillRepository;
    }

    public HardSkillEntity createHardSkillEntity() {
        return new HardSkillEntity();
    }

    public List<HardSkillEntity> findAllHardSkills() {
        return new ArrayList<>(hardSkillRepository.findAll());
    }

    public HardSkillEntity findHardSkillById(long hardSkillId) {
        return hardSkillRepository.findById(hardSkillId)
                .orElseThrow(() -> new NoSuchElementException("unknown hardskill entity with id: " + hardSkillId));
    }

    public HardSkillEntity updateHardSkill(long hardSkillId, @NonNull HardSkillEntity hardSkillEntity) {
        HardSkillEntity updatedHardSkillEntity = findHardSkillById(hardSkillId);
        updatedHardSkillEntity.setHardSkillId(hardSkillEntity.getHardSkillId());
        updatedHardSkillEntity.setHardSkillName(hardSkillEntity.getHardSkillName());
        updatedHardSkillEntity.setHardSkillValue(hardSkillEntity.getHardSkillValue());
        return persistHardSkill(updatedHardSkillEntity);
    }

    public HardSkillEntity persistHardSkill(@NonNull final HardSkillEntity hardSkillEntity) {
        try {
            return hardSkillRepository.save(hardSkillEntity);
        } catch (EntityExistsException exception) {
            throw new EntityExistsException("hardskillentity with id:" + hardSkillEntity.getHardSkillId() + " already exists.");
        }
    }

    public void deleteHardSkill(@NonNull final HardSkillEntity hardSkillEntity) {
        hardSkillRepository.deleteById(hardSkillEntity.getHardSkillId());
    }

    public void deleteHardSkillById(long hardSkillId) {
        hardSkillRepository.deleteById(hardSkillId);
    }
}
