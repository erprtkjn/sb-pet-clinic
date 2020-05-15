package prtk.springframework.sbpetclinic.services.map;

import net.bytebuddy.implementation.bind.annotation.Super;
import prtk.springframework.sbpetclinic.model.Vet;
import prtk.springframework.sbpetclinic.services.CrudService;

import java.util.Set;

public class VetServiceMap  extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteByID(aLong);
    }
}
