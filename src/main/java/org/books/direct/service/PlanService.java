package org.books.direct.service;

import java.util.List;

import org.books.direct.domain.entities.Plan;
import org.books.direct.domain.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService {

   @Autowired
   private PlanRepository planRepository;

   public List<Plan> getAllPlans() {
      return planRepository.findAll();
   }

   public List<Plan> getActivePlans() {
      return planRepository.findByActiveTrue();
   }

}
