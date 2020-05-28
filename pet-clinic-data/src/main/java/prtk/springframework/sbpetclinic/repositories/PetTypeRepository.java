package prtk.springframework.sbpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import prtk.springframework.sbpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
