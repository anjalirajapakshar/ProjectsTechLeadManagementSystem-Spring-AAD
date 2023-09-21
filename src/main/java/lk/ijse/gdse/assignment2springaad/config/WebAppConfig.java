package lk.ijse.gdse.assignment2springaad.config;

import lk.ijse.gdse.assignment2springaad.endpoints.TechLeadController;
import lk.ijse.gdse.assignment2springaad.response.Response;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = {Response.class, TechLeadController.class})
@EnableWebMvc
public class WebAppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
