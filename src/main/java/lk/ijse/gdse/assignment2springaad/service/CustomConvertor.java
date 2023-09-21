package lk.ijse.gdse.assignment2springaad.service;

import lk.ijse.gdse.assignment2springaad.dto.ProjectDTO;
import lk.ijse.gdse.assignment2springaad.entity.Project;

public class CustomConvertor {
    public static ProjectDTO toProjectsDTO(Project project){
        return new ProjectDTO(project.getProjectId(),project.getProjectName(),project.getProjectDescription(),project.getProjectDeadline(),project.getTechLeadId().getTechLeadId());
    }
}
