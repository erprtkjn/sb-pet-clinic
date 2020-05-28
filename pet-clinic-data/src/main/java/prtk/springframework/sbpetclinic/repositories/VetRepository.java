package prtk.springframework.sbpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import prtk.springframework.sbpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
