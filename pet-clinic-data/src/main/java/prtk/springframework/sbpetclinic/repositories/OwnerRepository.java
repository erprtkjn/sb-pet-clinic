package prtk.springframework.sbpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import prtk.springframework.sbpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
