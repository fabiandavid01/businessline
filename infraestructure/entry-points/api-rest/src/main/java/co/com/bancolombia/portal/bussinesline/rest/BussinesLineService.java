package co.com.bancolombia.portal.bussinesline.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.bancolombia.portal.bussinesline.usecase.BussinesLineUseCase;
import co.com.bancolombia.portal.domain.bussinesline.dto.RequestBussinesLineDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/portal/bussinesline", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BussinesLineService {
	
	private final BussinesLineUseCase useCase;

	
	
	@SuppressWarnings("rawtypes")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/getbussinesline")
    public ResponseEntity getApis(@RequestBody RequestBussinesLineDTO requestBussinesLineDTO) {	
		return ResponseEntity.ok(useCase.getBussinesLine(requestBussinesLineDTO));
    }
	

}
