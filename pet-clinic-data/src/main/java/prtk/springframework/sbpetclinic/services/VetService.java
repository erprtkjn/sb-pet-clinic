package prtk.springframework.sbpetclinic.services;

import prtk.springframework.sbpetclinic.model.Owner;
import prtk.springframework.sbpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
