package prtk.springframework.sbpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import prtk.springframework.sbpetclinic.model.Owner;
import prtk.springframework.sbpetclinic.model.Pet;
import prtk.springframework.sbpetclinic.services.OwnerService;
import prtk.springframework.sbpetclinic.services.PetService;
import prtk.springframework.sbpetclinic.services.PetTypeService;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

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

        if(object != null){
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(object);

        } else {
            return null;
        }

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
        return this.findAll()
                .stream()
                .filter(isLastNameEqual(lastName))
                .findFirst()
                .orElse(null);
    }

    Predicate<Owner> isLastNameEqual(String lName) {
        return p -> p.getLastName().equalsIgnoreCase(lName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {

        //todo - impl
        return null;
    }
}
