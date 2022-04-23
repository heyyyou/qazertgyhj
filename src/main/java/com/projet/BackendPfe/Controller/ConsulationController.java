package com.projet.BackendPfe.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projet.BackendPfe.model.AutoDetection;
import com.projet.BackendPfe.model.AvisExpert;
import com.projet.BackendPfe.model.Consultation;
import com.projet.BackendPfe.model.Expert;
import com.projet.BackendPfe.model.Generaliste;
import com.projet.BackendPfe.model.Patient;
import com.projet.BackendPfe.repository.AutoDetectionRepository;
import com.projet.BackendPfe.repository.AvisExpertRepository;
import com.projet.BackendPfe.repository.ConsultationRepository;
import com.projet.BackendPfe.repository.ExpertRepository;
import com.projet.BackendPfe.repository.GeneralisteRepository;
import com.projet.BackendPfe.repository.PatientRepository;
import com.projet.BackendPfe.services.ConsultationService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/consultation")
public class ConsulationController {
	@Autowired ConsultationRepository repository ;
	@Autowired GeneralisteRepository medecinRepository;
	@Autowired PatientRepository patientRepository;
	@Autowired ExpertRepository expertRepository;
	@Autowired ConsultationService service ; 
	@Autowired AutoDetectionRepository pr ; 
    @Autowired AvisExpertRepository avis; 
	@PostMapping("/Consultations/{idGeneraliste}/{idPatient}")
	public Consultation addConsultation(@PathVariable("idGeneraliste") long idGeneraliste , 
			                                                                 @PathVariable("idPatient") long idPatient   ){
		Generaliste  generaliste = medecinRepository.findById(idGeneraliste).get(); 
		Patient patient = patientRepository.findById(idPatient).get() ; 
		byte[] image1 = null ; 
		byte[] image2 = null ; 
		byte[] image3 = null ; 
		byte[] image4 = null ; 
		byte[] image5 = null ; 
		byte[] image6 = null ; 
		byte[] image7 = null ; 
		byte[] image8 = null ; 
		byte[] image9 = null ; 
		byte[] image10 = null ; 
		
		
		

		Consultation consultation = new Consultation(generaliste, patient,LocalDate.now(),image1,image2,image3,image4,image5,image6,image7,image8,image9,image10);
		repository.save(consultation) ;
		return consultation ; 

	}
	
	
	@PutMapping("consultation/{idAvisExpert}/{idConsultation}") //updateIDAvis expert f classe mtaa consultation wa9teh ?
	//wa9teli naamlu post l avis Expert ;) 
	public void updateIdAvisExpert(@PathVariable("idAvisExpert") long idAvisExpert, @PathVariable("idConsultation") long idConsultation ){
		 Consultation consult =repository.findById(idConsultation).get();
	AvisExpert avisExpert = avis.findById(idAvisExpert).get(); 
		 consult.setAvisExpert(avisExpert);
		 repository.save(consult);

	}
	
	
	
	
	//deleteAll Pictures 
	@PutMapping("consultation/picturesD/{id}/{idConsultation}")
	public void deleteConsult(@PathVariable("id") long id, @PathVariable("idConsultation") long idConsultation){
		 Consultation consult =repository.findById(idConsultation).get();
		 consult.setImage1_Droite(null);
		 consult.setImage2_Droite(null);
		 consult.setImage3_Droite(null);
		 consult.setImage4_Droite(null);
		 consult.setImage5_Droite(null);
		 repository.save(consult);

	}
	@PutMapping("consultation/picturesG/{id}/{idConsultation}")
	public void deleteConsultG(@PathVariable("id") long id, @PathVariable("idConsultation") long idConsultation){
		 Consultation consult =repository.findById(idConsultation).get();
		 consult.setImage1_Gauche(null);
		 consult.setImage2_Gauche(null);
		 consult.setImage3_Gauche(null);
		 consult.setImage4_Gauche(null);
		 consult.setImage5_Gauche(null);
		 repository.save(consult);

	}

	// put for expert baed f avis demander 
	
	/*@PutMapping("SendConsultation/{idConsultation}/{idExpert}")
	public Consultation EnvoyerConultationAunExpert(@PathVariable("idConsultation") long idConsultation , 
			                                                                                               @PathVariable("idExpert") long idExpert) {
		Consultation consultation = repository.findById(idConsultation).get() ;
		Expert expert = expertRepository.findById(idExpert).get() ;
	   consultation.setExpert(expert);
	   repository.save(consultation) ;
	   return consultation ; 
	}/*
	/***********Oeil Droite *************/
	
	@PutMapping("/addimage1D/{idConsultation}")
	public String updateImage1D(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image1") MultipartFile image1) throws IOException {
		service.updateImage1Droite(idConsultation , image1);
		return "Done pour image1 Droite !!!!" ; 
	}

	@PutMapping("/addimage2D/{idConsultation}")
	public String updateImage2D(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image2") MultipartFile image2 ) throws IOException {
			service.updateImage2Droite(idConsultation,  image2);
		return "Done pour image2  Droite!!!!" ; 
	}
	@PutMapping("/addimage3D/{idConsultation}")
	public String updateImage3D(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image3") MultipartFile image3) throws IOException {
		service.updateImage3Droite(idConsultation , image3);
		return "Done pour image3 Droite !!!!" ; 
	}
	@PutMapping("/addimage4D/{idConsultation}")
	public String updateImage4D(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image4") MultipartFile image4 ) throws IOException {
		service.updateImage4Droite(idConsultation , image4);
		return "Done pour image4  Droite!!!!" ; 
	}
	@PutMapping("/addimage5D/{idConsultation}")
	public String updateImage5D(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image5") MultipartFile image5        ) throws IOException {

		service.updateImage5Droite(idConsultation, image5);
		return "Done pour image5 Droite  !!!!" ; 
	}
	
	
	/***********Oeil Gauche *************/
	
	@PutMapping("/addimage1G/{idConsultation}")
	public String updateImage1G(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image1") MultipartFile image1  ) throws IOException {
		Consultation consultation = repository.findById(idConsultation).get();
		service.updateImage1Gauche(idConsultation , image1);
		return "Done pour image1 Gauche !!!!" ; 
	}
	@PutMapping("/addimage2G/{idConsultation}")
	public String updateImage2G(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image2") MultipartFile image2 ) throws IOException {
		Consultation consultation = repository.findById(idConsultation).get();
		service.updateImage2Gauche(idConsultation, image2);
		return "Done pour image2  Gauche!!!!" ; 
	}
	@PutMapping("/addimage3G/{idConsultation}")
	public String updateImage3G(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image3") MultipartFile image3 ) throws IOException {
		Consultation consultation = repository.findById(idConsultation).get();
		service.updateImage3Gauche(idConsultation, image3);
		return "Done pour image3 Gauche !!!!" ; 
	}
	@PutMapping("/addimage4G/{idConsultation}")
	public String updateImage4G(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image4") MultipartFile image4 ) throws IOException {
		Consultation consultation = repository.findById(idConsultation).get();
		service.updateImage4Gauche(idConsultation,  image4);
		return "Done pour image4  Gauche!!!!" ; 
	}
	@PutMapping("/addimage5G/{idConsultation}")
	public String updateImage5G(@PathVariable("idConsultation") long idConsultation  , @RequestParam("image5") MultipartFile image5        ) throws IOException {
		Consultation consultation = repository.findById(idConsultation).get();
		service.updateImage5Gauche(idConsultation , image5);
		return "Done pour image5 Gauche  !!!!" ; 
	}
	
	
	@DeleteMapping("/deleteConsult/{id}/{idConsultation}")
	public void deleteProduct(@PathVariable("idConsultation") long idConsultation){
		
	
		repository.deleteById(idConsultation);
	} 
	@GetMapping("/Consultations/{id}")
	public List<Consultation> getAllProducts(@PathVariable("id") @ModelAttribute("id") long id){
         //pr.findById(id);
	    return  repository.findByGeneraliste_id(id);

	} 
	@GetMapping("/Consultation/{id}/{idPatient}") // hehdy pour lien de consultation pour chaque patient
	public List<Consultation> getConsultationsByPatient (@PathVariable("id") long id ,@PathVariable ("idPatient") long idPatient){
	
    return repository.findByPatient_cinAndGeneraliste_id(idPatient,id);		 
		
	}
	@GetMapping("/Consultations") // hdhy st79itha f expert avis 
 	public List<Consultation> getAllConsultation(){
         //pr.findById(id);
	    return  repository.findAll();

	} 
	
	
	@GetMapping("/Consultation/{id}/{idConsultation}/{idPatient}")
	public Consultation getAllProductsbyid(@PathVariable("id") long id,@PathVariable("idConsultation") long idConsultation,@PathVariable("idPatient") long idPatient){
		Consultation conster = repository.findById(idConsultation).get();
		 if( conster.getImage1_Droite()== null) {
			  return conster;
		  }
		  else {
			    conster.setImage1_Droite(service.decompressZLib(conster.getImage1_Droite()));}	
			    
			    if( conster.getImage2_Droite()== null) {
					  return conster;
				  }
				  else {
					    conster.setImage2_Droite(service.decompressZLib(conster.getImage2_Droite()));	}
		
					    if( conster.getImage3_Droite()== null) {
							  return conster;
						  }
						  else {
							    conster.setImage3_Droite(service.decompressZLib(conster.getImage3_Droite()));	}
				
							    if( conster.getImage4_Droite()== null) {
									  return conster;
								  }
								  else {
									    conster.setImage4_Droite(service.decompressZLib(conster.getImage4_Droite()));	}
									    
									    if( conster.getImage5_Droite()== null) {
											  return conster;
										  }
										  else {
											    conster.setImage5_Droite(service.decompressZLib(conster.getImage5_Droite()));}
									    
									    
									    
									    
									    
											    
											    if( conster.getImage1_Gauche()== null) {
													  return conster;
												  }
												  else {
													    conster.setImage1_Gauche(service.decompressZLib(conster.getImage1_Gauche()));}
													    
													    if( conster.getImage2_Gauche()== null) {
															  return conster;
														  }
														  else {
															    conster.setImage2_Gauche(service.decompressZLib(conster.getImage2_Gauche()));}
															    
															    if( conster.getImage3_Gauche()== null) {
																	  return conster;
																  }
																  else {
																	    conster.setImage3_Gauche(service.decompressZLib(conster.getImage3_Gauche()));	}
														
																	    if( conster.getImage4_Gauche()== null) {
																			  return conster;
																		  }
																		  else {
																			    conster.setImage4_Gauche(service.decompressZLib(conster.getImage4_Gauche()));	}
																			    
																			    if( conster.getImage5_Gauche()== null) {
																					  return conster;
																				  }
																				  else {
																					    conster.setImage5_Gauche(service.decompressZLib(conster.getImage5_Gauche()));	}
																		
																
												
										
						
		return conster;
		  
		
	}
	// input id de Auto detection dans consultation
	
	
	@PutMapping("/editAuto/{idGeneraliste}/{idConsult}/{idAutoDetection}")
	public String updateID(@PathVariable("idGeneraliste") long idGeneraliste,@PathVariable("idConsult") long idConsult,  @PathVariable("idAutoDetection") long idAutoDetection) {
	Consultation consultation = repository.findById(idConsult).get();
		AutoDetection autp =pr.findById(idAutoDetection).get();
           consultation.setAutoDetection(autp);
		repository.save(consultation);
		return "Done pour changement ID  !!!!" ; 
	}
	@PutMapping("/demanderAvis/{idGeneraliste}/{idConsult}")
	public String udemanderAvisID(@PathVariable("idGeneraliste") long idGeneraliste,@PathVariable("idConsult") long idConsult) {
	Consultation consultation = repository.findById(idConsult).get();
           consultation.setDemandeAvis(1);
		repository.save(consultation);
		return "Done pour changement ID  !!!!" ; 
	}
	
}
	/*
	 public void AddProduct(@PathVariable("id") long id ,@PathVariable("cin") long cin  ){
		Generaliste gen = pr1.findById(id).get();
		Patient pat = pr2.findById(cin).get();
	
		Consultation data = new Consultation(gen,pat);
		
		pr.save(data);
	}*/
	
