package prtk.springframework.sbpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import prtk.springframework.sbpetclinic.model.*;
import prtk.springframework.sbpetclinic.services.OwnerService;
import prtk.springframework.sbpetclinic.services.PetTypeService;
import prtk.springframework.sbpetclinic.services.SpecialtyService;
import prtk.springframework.sbpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Prtk");
        owner1.setLastName("Jain");
        owner1.setAddress("Oerlikon");
        owner1.setCity("Zurich");
        owner1.setTelephone("779927235");

        Pet prtksPet = new Pet();
        prtksPet.setPetType(savedDogPetType);
        prtksPet.setOwner(owner1);
        prtksPet.setBirthDate(LocalDate.now());
        prtksPet.setName("Rosco");
        owner1.getPets().add(prtksPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Aaku");
        owner2.setLastName("Jain");
        owner2.setAddress("Gorakshan");
        owner2.setCity("Akola");
        owner2.setTelephone("8989898989");

        Pet aakusCat = new Pet();
        aakusCat.setName("Dinu");
        aakusCat.setBirthDate(LocalDate.now());
        aakusCat.setOwner(owner2);
        aakusCat.setPetType(savedCatPetType);
        owner2.getPets().add(aakusCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...!!!");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Kartik");
        vet1.setLastName("Aryan");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Ayushman");
        vet2.setLastName("Khurana");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...!!!");
    }
}
