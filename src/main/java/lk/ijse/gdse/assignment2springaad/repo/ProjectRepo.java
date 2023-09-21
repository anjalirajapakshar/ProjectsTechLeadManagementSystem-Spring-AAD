package lk.ijse.gdse.assignment2springaad.repo;

import lk.ijse.gdse.assignment2springaad.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, String> {
}
