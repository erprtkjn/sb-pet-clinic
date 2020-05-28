package prtk.springframework.sbpetclinic.services.map;

import org.springframework.stereotype.Service;
import prtk.springframework.sbpetclinic.model.Speciality;
import prtk.springframework.sbpetclinic.model.Vet;
import prtk.springframework.sbpetclinic.services.SpecialtyService;
import prtk.springframework.sbpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

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
        if(object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpecialty = specialtyService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
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