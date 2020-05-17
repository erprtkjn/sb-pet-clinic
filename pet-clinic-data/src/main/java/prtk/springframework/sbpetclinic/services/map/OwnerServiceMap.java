package prtk.springframework.sbpetclinic.services.map;

import prtk.springframework.sbpetclinic.model.Owner;
import prtk.springframework.sbpetclinic.services.CrudService;
import prtk.springframework.sbpetclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteByID(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
