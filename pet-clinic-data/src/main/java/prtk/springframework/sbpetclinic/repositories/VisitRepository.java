package prtk.springframework.sbpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import prtk.springframework.sbpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
