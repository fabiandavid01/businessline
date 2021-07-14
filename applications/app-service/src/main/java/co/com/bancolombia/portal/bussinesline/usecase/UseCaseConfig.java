package co.com.bancolombia.portal.bussinesline.usecase;

import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.bancolombia.portal.domain.bussinesline.technicalogs.gateways.LoggerRepository;

@Configuration
public class UseCaseConfig {
	
	@Bean
    public BussinesLineUseCase createBussinesLineUseCase(LoggerRepository logger) {
        return new BussinesLineUseCase(logger);
    }

    @Bean
    public ObjectMapperImp createObjectMapper() {
        return new ObjectMapperImp();
    }

}

