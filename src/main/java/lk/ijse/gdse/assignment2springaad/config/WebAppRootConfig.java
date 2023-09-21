package lk.ijse.gdse.assignment2springaad.config;

import lk.ijse.gdse.assignment2springaad.service.ProjectServiceImpl;
import lk.ijse.gdse.assignment2springaad.service.TechLeadServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan
@EnableWebMvc
@Import({JPAConfiguration.class, TechLeadServiceImpl.class, ProjectServiceImpl.class})
public class WebAppRootConfig {
}
