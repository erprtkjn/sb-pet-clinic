package prtk.springframework.sbpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import prtk.springframework.sbpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
