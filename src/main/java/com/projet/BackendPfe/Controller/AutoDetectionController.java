package com.projet.BackendPfe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.BackendPfe.model.AutoDetection;
import com.projet.BackendPfe.model.Consultation;
import com.projet.BackendPfe.model.Expert;
import com.projet.BackendPfe.model.Generaliste;
import com.projet.BackendPfe.model.Patient;
import com.projet.BackendPfe.repository.AutoDetectionRepository;
import com.projet.BackendPfe.repository.ConsultationRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Auto")
public class AutoDetectionController {
	@Autowired AutoDetectionRepository repository ;
	@Autowired ConsultationRepository pr;
	@PostMapping("/auto/{idGeneraliste}/{idConsultation}")
	public AutoDetection addConsultation(@PathVariable("idGeneraliste") long idGeneraliste , 
			                                                                 @PathVariable("idConsultation") long idConsultation  )
	{
		Consultation consultation = pr.findById(idConsultation).get(); 
	
	String maladieGauche=null;
	String maladieDroite=null;
	int graviteDroite=0;
	int graviteGauche=0;
		
		

		AutoDetection autoDetection = new AutoDetection(maladieDroite,maladieGauche,graviteDroite,graviteGauche);
		repository.save(autoDetection) ;
		return autoDetection;


	}

}

