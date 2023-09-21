package lk.ijse.gdse.assignment2springaad.repo;

import lk.ijse.gdse.assignment2springaad.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TechLeadRepo extends JpaRepository<TechLead, String> {

    @Query("select t from TechLead t where t.techLeadId = ?1")
    TechLead findTechLead(String techLeadId);

}
