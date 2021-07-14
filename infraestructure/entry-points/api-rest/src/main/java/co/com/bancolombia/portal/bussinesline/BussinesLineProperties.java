package co.com.bancolombia.portal.bussinesline;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Component
@ConfigurationProperties(prefix="data.bussinesline")
public class BussinesLineProperties {
 

 
}