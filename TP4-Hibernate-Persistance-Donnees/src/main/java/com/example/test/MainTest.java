package com.example.test;

import com.example.entities.Machine;
import com.example.entities.Salle;
import com.example.services.MachineService;
import com.example.services.SalleService;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        List<Machine> dells = machineService.findByMarque("Dell");
        for (Machine m : dells) {
            System.out.println(m.getRef() + " - " + m.getMarque());
        }
        Salle salleA = new Salle();
        salleA.setCode("S1");
        salleA.setLibelle("Salle Informatique");

        salleService.create(salleA);

        Machine machine = new Machine();
        machine.setRef("M-101");
        machine.setMarque("Dell");
        machine.setSalle(salleA);

        machineService.create(machine);

        System.out.println("Données insérées avec succès !");
    }
}