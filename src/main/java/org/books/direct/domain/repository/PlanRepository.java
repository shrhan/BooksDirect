package org.books.direct.domain.repository;

import java.util.List;

import org.books.direct.domain.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {

   List<Plan> findByActiveTrue();

}
