package prtk.springframework.sbpetclinic.services;

import prtk.springframework.sbpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
