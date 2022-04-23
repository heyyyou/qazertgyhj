package com.projet.BackendPfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.BackendPfe.model.AutoDetection;
import com.projet.BackendPfe.model.AvisExpert;

public interface AvisExpertRepository extends JpaRepository<AvisExpert, Long> {

}
