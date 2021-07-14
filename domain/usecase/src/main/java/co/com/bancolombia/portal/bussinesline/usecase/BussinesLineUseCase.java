package co.com.bancolombia.portal.bussinesline.usecase;


import co.com.bancolombia.portal.domain.bussinesline.dto.RequestBussinesLineDTO;
import co.com.bancolombia.portal.domain.bussinesline.dto.ResponseBussinesLineDTO;
import co.com.bancolombia.portal.domain.bussinesline.technicalogs.gateways.LoggerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BussinesLineUseCase{

	
    private final LoggerRepository logger;
    private ResponseBussinesLineDTO responseBussinesLineDTO;
    
    public ResponseBussinesLineDTO getBussinesLine(RequestBussinesLineDTO requestBussinesLineDTO) {
        try {
            
        } catch (Exception e) {
            
        }
        return responseBussinesLineDTO;
    }
    
	
    private final ConfigurationSSLContext configurationSSLContext = new ConfigurationSSLContext();;
    
	
	
}
