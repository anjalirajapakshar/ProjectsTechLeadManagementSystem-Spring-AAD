package lk.ijse.gdse.assignment2springaad.service;

import lk.ijse.gdse.assignment2springaad.dto.ProjectDTO;
import lk.ijse.gdse.assignment2springaad.entity.Project;
import lk.ijse.gdse.assignment2springaad.entity.TechLead;
import lk.ijse.gdse.assignment2springaad.repo.ProjectRepo;
import lk.ijse.gdse.assignment2springaad.repo.TechLeadRepo;
import lk.ijse.gdse.assignment2springaad.response.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TechLeadRepo techLeadRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public Response save(ProjectDTO projectDTO) {

        if (search(projectDTO.getProjectId()).getData()==null){
            Optional<TechLead> techLead = techLeadRepo.findById(projectDTO.getTechLeadId());

            if (techLead.isPresent()){
                Project project = modelMapper.map(projectDTO, Project.class);
                project.setTechLeadId(techLead.get());
                projectRepo.save(project);
                return createAndSendResponse(HttpStatus.OK.value(), "Project successfully saved!", null);
            } else {
                throw new RuntimeException("TechLead does not exists!");
            }
        }
        throw new RuntimeException("Project already exists!");

    }

    @Override
    public Response update(ProjectDTO projectDTO) {
        if (search(projectDTO.getProjectId()).getData() != null) {
            Optional<TechLead> techLead = techLeadRepo.findById(projectDTO.getTechLeadId());

            if (techLead.isPresent()) {
                Project project = modelMapper.map(projectDTO, Project.class);
                project.setTechLeadId(techLead.get());
                projectRepo.save(project);
                return createAndSendResponse(HttpStatus.OK.value(), "Successfully updated the project!", null);

            } else {
                throw new RuntimeException("TechLead does not exists!");
            }

        } return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Project does not exists", null);
    }

    @Override
    public Response delete(String s) {
        if(search(s).getData()!=null){
            projectRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(),"Successfully deleted the project",null);

        }
        throw new RuntimeException("Project does not exists!");
    }

    @Override
    public Response search(String s) {

        Optional<Project> project = projectRepo.findById(s);
        if (project.isPresent()){
            return createAndSendResponse(HttpStatus.OK.value(), "Project Successfully retrieved",CustomConvertor.toProjectsDTO(project.get()));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Project not found",null);

    }

    @Override
    public Response getAll() {
        List<Project> projects = projectRepo.findAll();
        if(!projects.isEmpty()){
            List<ProjectDTO> projectsDTOs = new ArrayList<>();
            projects.forEach((project)->{
                projectsDTOs.add(CustomConvertor.toProjectsDTO(project));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(),"Projects successfully retrieved!",projectsDTOs );
        }
        throw new RuntimeException("No projects were found in the DB!");
    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
