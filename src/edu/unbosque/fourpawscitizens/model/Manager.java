package edu.unbosque.fourpawscitizens.model;

import edu.unbosque.fourpawscitizens.model.dtos.Pet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Manager {
    private ArrayList<Pet> listOfPet;

    public Manager() throws IOException {

        listOfPet = new ArrayList<Pet>();
        this.uploadData();
        this.assignID();
    }

    private void assignID() {
        String message = "";

        for (int i = 0; i < listOfPet.size(); i++) {
            try {
                long pMicrochip = listOfPet.get(i).getMicrochip();
                String n = String.valueOf(pMicrochip);
                String jMicrochip = n.substring(n.length() - 3, n.length());
                String pSpecies = listOfPet.get(i).getSpecies();
                String jSpecies = pSpecies.substring(0, 1).toUpperCase();
                String pSex = listOfPet.get(i).getSex();
                String jSex = pSex.substring(0, 1).toUpperCase();
                String pSize = listOfPet.get(i).getSize();
                String jSize = "";
                if (pSize.equals("MINIATURA")) {
                    jSize = pSize.substring(0, 2).toUpperCase();
                } else {
                    jSize = pSize.substring(0, 1).toUpperCase();
                }
                boolean pDangerous = listOfPet.get(i).getPotentDangerous();
                String n1 = String.valueOf(pDangerous);
                String jDangerous = n1.substring(0, 1).toUpperCase();
                String pNeighborhood = listOfPet.get(i).getNeighborhood().toUpperCase();
                message = jMicrochip + "-" + jSpecies + jSex + jSize + jDangerous + "-" + pNeighborhood;
                listOfPet.get(i).setId(message);
            } catch (Exception e) {
            }
        }
    }


    public void uploadData() {

        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader("C:\\Users\\fabic\\FourPawsCitizens\\src\\edu\\unbosque\\fourpawscitizens\\data\\pets-citizens.csv"));
            String line = br.readLine();

            while (null != line) {
                Pet pet = new Pet();
                String[] fields = line.split(";");

                if (fields.length == 6) {

                    pet.setId("NO-ID");
                    try {
                        pet.setMicrochip(Long.parseLong(fields[0]));
                        pet.setSpecies(fields[1]);
                        pet.setSex(fields[2]);
                        pet.setSize(fields[3]);
                        if (fields[4].equals("SI")) {
                            fields[4] = "true";
                        } else {
                            fields[4] = "false";
                        }
                        pet.setPotentDangerous(Boolean.parseBoolean(fields[4]));
                        pet.setNeighborhood(fields[5]);
                        listOfPet.add(pet);
                    } catch (NumberFormatException e) {

                    }

                }
                line = br.readLine();
            }

        } catch (Exception e) {

        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private String findByMicrochip (String pMicrochip){
        String message = "";
        try {
            for (int i = 0; i < listOfPet.size(); i++) {

                if (Long.parseLong(pMicrochip) == listOfPet.get(i).getMicrochip()) {
                    message += "ID: " + listOfPet.get(i).getId() + "\n" + "Species: " + listOfPet.get(i).getSpecies() + "\n"
                            + "Gender: " + listOfPet.get(i).getSex() + "\n" + "Size: " + listOfPet.get(i).getSize() + "\n" + "Potentially dangerous: " + listOfPet.get(i).getPotentDangerous() + "\n" + "Neighborhood: " + listOfPet.get(i).getNeighborhood() + "\n";
                }

            }

        } catch (Exception e) {
            System.out.println("Error, not found microchip");
        }
        return message;
    }

    private String countBySpecies (String pSpecie){
        String message = "";
        int cont = 0;
        for (int i = 0; i < listOfPet.size(); i++) {

            if (pSpecie.equals(listOfPet.get(i).getSpecies())) {
                cont++;
            }
        }
        if (cont > 1) {
            message += "The number of animals of the " + pSpecie + " species is: " + cont;
        } else {
            message += "The species was not found";
        }
        return message;
    }

    public String findBypotentDangerousInNeighborhood ( int n, String option, String neighborhood){
        String message = "";
        int count = 0;
        if (option.equals("TOP")) {
            for (int i = 0; i < listOfPet.size(); i++) {
                if (listOfPet.get(i).getPotentDangerous() && listOfPet.get(i).getNeighborhood().equals(neighborhood)) {
                    count++;
                    if (count <= n) {
                        message += "ID: " + listOfPet.get(i).getId() + "\n" + "Species: " + listOfPet.get(i).getSpecies() + "\n"
                                + "Gender: " + listOfPet.get(i).getSex() + "\n" + "Size: " + listOfPet.get(i).getSize() + "\n" + "Potentially dangerous: " + listOfPet.get(i).getPotentDangerous() + "\n" + "Neighborhood: " + listOfPet.get(i).getNeighborhood() + "\n";
                    }
                }
            }
        } else if (option.equals("LAST")) {
            for (int i = listOfPet.size() - 1; i >= 0; i--) {
                if (listOfPet.get(i).getPotentDangerous() && listOfPet.get(i).getNeighborhood().equals(neighborhood)) {
                    count++;
                    if (count <= n) {
                        message += "ID: " + listOfPet.get(i).getId() + "\n" + "Species: " + listOfPet.get(i).getSpecies() + "\n"
                                + "Gender: " + listOfPet.get(i).getSex() + "\n" + "Size: " + listOfPet.get(i).getSize() + "\n" + "Potentially dangerous: " + listOfPet.get(i).getPotentDangerous() + "\n" + "Neighborhood: " + listOfPet.get(i).getNeighborhood() + "\n";
                    }
                }
            }
        }
        return message;
    }
}