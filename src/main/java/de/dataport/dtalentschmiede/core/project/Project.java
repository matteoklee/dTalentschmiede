package de.dataport.dtalentschmiede.core.project;

import de.dataport.dtalentschmiede.core.project.enums.*;

import java.util.Date;
import java.util.List;

/**
 * Class "Project" is used for ...
 *
 * @author Matteo Kleemann
 * @version 1.0
 * @since 22.10.2024
 */
public interface Project {

    public Long getProjectId();

    public void setProjectId(Long projectId);

    public String getProjectTitle();

    public void setProjectTitle(String projectTitle);

    public String getProjectDescription();

    public void setProjectDescription(String projectDescription);

    public ProjectStatus getProjectStatus();

    public void setProjectStatus(ProjectStatus projectStatus);
    public Date getProjectCreatedAt();

    public void setProjectCreatedAt(Date projectCreatedAt);
    public Date getProjectUpdatedAt();

    public void setProjectUpdatedAt(Date projectUpdatedAt);

    public Date getProjectFinishedAt();

    public void setProjectFinishedAt(Date projectFinishedAt);

    public List<ProjectType> getProjectTypes();

    public void setProjectTypes(List<ProjectType> projectTypes);

    public List<Technology> getProjectTechnologies();
    public void setProjectTechnologies(List<Technology> projectTechnologies) ;

    public List<SoftSkill> getProjectSoftSkills();

    public void setProjectSoftSkills(List<SoftSkill> projectSoftSkills);

    public List<HardSkill> getProjectHardSkills();

    public void setProjectHardSkills(List<HardSkill> projectHardSkills);

    public String getProjectRepresentative();
    public void setProjectRepresentative(String projectRepresentative);

    public String getProjectRepresentativeEmail();

    public void setProjectRepresentativeEmail(String projectRepresentativeEmail);

}
