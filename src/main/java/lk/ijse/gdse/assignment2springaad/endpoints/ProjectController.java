package lk.ijse.gdse.assignment2springaad.endpoints;

import lk.ijse.gdse.assignment2springaad.dto.ProjectDTO;
import lk.ijse.gdse.assignment2springaad.response.Response;
import lk.ijse.gdse.assignment2springaad.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService projectsService;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody ProjectDTO projectsDto) {
        return projectsService.save(projectsDto);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody ProjectDTO projectsDto) {
        return projectsService.update(projectsDto);
    }

    @GetMapping(path = "/search", params = "projectId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("projectId") String projectId) {
        return projectsService.search(projectId);
    }

    @DeleteMapping(path = "/delete", params = "projectId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("projectId") String projectId) {
        return projectsService.delete(projectId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return projectsService.getAll();
    }
}

//{
//        "projectId":"P001",
//        "projectName":"CSMange",
//        "projectDescription":"Customer management system",
//        "projectDeadline":"2023.11.31",
//        "techLeadId":"T001"
//}