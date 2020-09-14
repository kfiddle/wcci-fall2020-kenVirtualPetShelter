import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelter {
    HashMap<String, VirtualPet> pets = new HashMap<String, VirtualPet>();

    public void add(VirtualPet homeless) {
        pets.put(homeless.getName(), homeless);
    }

    public boolean confirmName(String name) {
        return pets.containsKey(name);
    }



    public void displayPets(String typeOfDisplay) {
        if (typeOfDisplay.equals("full")) {
            String printedPets = "";
            System.out.println("NAME       Assessment    Hunger   Thirst   Anxiety   Fatigue   Need to hunt\n");
            for (VirtualPet pet : pets.values()) {
                System.out.println(pet.petToString());
            }
        } else if (typeOfDisplay.equals("nameAndDescript") ) {
            for (VirtualPet pet : pets.values()) {
                System.out.printf("%-10s %s", pet.getName(), pet.getDescription());
                System.out.println();
            }
        }
    }

    public void assessAllPets(){
        for (VirtualPet pet : pets.values()){
            pet.setAssessment();
        }
    }

    public void tick() {
        for (VirtualPet pet : pets.values()) {
            int i = 2;
            pet.addHunger(i);
            pet.addThirst(i);
            pet.addFatigue(i);

        }
    }

    public void adopt(String name) {
        pets.remove(name);
    }

    public void feedAll(int i) {
        for (VirtualPet pet : pets.values()) {
            pet.feed(i);
        }
    }

    public void feedDryFood(String name, int servings) {
        pets.get(name).feedDryFood(servings);
    }

    public void feedWetFood(String name, int servings) {
        pets.get(name).feedWetFood(servings);
    }

    public void feedTreat(String name, int servings) {
        pets.get(name).feedTreat(servings);
    }


    public void waterAll(int i) {
        for (VirtualPet pet : pets.values()) {
            pet.giveWater(i);
        }
    }

    public void waterSpecificPet(String name){
        pets.get(name).giveWater(4);
    }

    public void strokePet(String name){
        pets.get(name).stroke();
    }

    public void playWith(String name) {
        pets.get(name).play();


    }


}



