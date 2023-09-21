package lk.ijse.gdse.assignment2springaad.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDTO implements Serializable,SuperDTO {
    private String projectId;
    private String projectName;
    private String projectDescription;
    private String projectDeadline;
    private String techLeadId;
}
