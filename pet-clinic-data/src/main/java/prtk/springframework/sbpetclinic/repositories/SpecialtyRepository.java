package prtk.springframework.sbpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import prtk.springframework.sbpetclinic.model.Speciality;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
