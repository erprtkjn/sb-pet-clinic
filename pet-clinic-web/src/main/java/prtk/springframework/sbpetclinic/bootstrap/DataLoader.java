package prtk.springframework.sbpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import prtk.springframework.sbpetclinic.model.Owner;
import prtk.springframework.sbpetclinic.model.Vet;
import prtk.springframework.sbpetclinic.services.OwnerService;
import prtk.springframework.sbpetclinic.services.VetService;
import prtk.springframework.sbpetclinic.services.map.OwnerServiceMap;
import prtk.springframework.sbpetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Prtk");
        owner1.setLastName("Jain");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(1L);
        owner2.setFirstName("Aaku");
        owner2.setLastName("Jain");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...!!!");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Mahatma");
        vet1.setLastName("Gandhi");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Ayushman");
        vet2.setLastName("Khurana");

        vetService.save(vet2);

        System.out.println("Loaded Vets...!!!");
    }
}
