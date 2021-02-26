package edu.unbosque.fourpawscitizens.model;

import edu.unbosque.fourpawscitizens.model.dtos.Pet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private ArrayList<Pet> listOfPet;
    Scanner read;

    public Manager() throws IOException {
        read = new Scanner(System.in);
        listOfPet = new ArrayList<Pet>();
        this.uploadData();
        this.assignID();
        this.run();
    }

    public void run() {
        String option = "-----FourPawsCitizens-----\n" +
                "1. Busqueda por microchip\n" +
                "2. Conteo de animales por especie\n" +
                "3. Busqueda de potencialmente peligroso por localidad\n" +
                "4. Busqueda por diferentes campos";
        System.out.println(option);
        int op = read.nextInt();
        String message = "";
        switch (op) {
            case 1:
                System.out.println("por favor ingrese el microchip del animal");
                long pMicrochip = read.nextLong();
                String pMicro = String.valueOf(pMicrochip);
                message = findByMicrochip(pMicro);
                System.out.println(message);
                System.out.println("quiere seguir en el programa?\n" + "1. Si\n" + "2. No");
                int exit = read.nextInt();
                switch (exit) {
                    case 1:
                        run();
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("LA OPCION NO ES CORRECTA");
                }
                break;

            case 2:
                System.out.println("por favor ingrese la especie del animal");
                String pSpecies = read.next();
                message = countBySpecies(pSpecies);
                System.out.println(message);
                System.out.println("\nquiere seguir en el programa?\n" + "1. Si\n" + "2. No");
                int exit2 = read.nextInt();
                switch (exit2) {
                    case 1:
                        run();
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("LA OPCION NO ES CORRECTA");
                }
                break;

            case 3:
                System.out.println("ingrese la cantidad de mascotas que quiere ver");
                int n = read.nextInt();
                System.out.println("escoja entre TOP o LAST");
                String position = read.next();
                System.out.println("escriba la localidad");
                String pNeighborhood = read.next();
                message = findBypotentDangerousInNeighborhood(n, position, pNeighborhood);
                System.out.println(message);
                System.out.println("\nquiere seguir en el programa?\n" + "1. Si\n" + "2. No");
                int exit3 = read.nextInt();
                switch (exit3) {
                    case 1:
                        run();
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("LA OPCION NO ES CORRECTA");
                }
                break;

            case 4:
                System.out.println("escoja entre estas especies\n" + "1. CANINO\n" + "2. FELINO");
                int s = read.nextInt();
                String pSpecie = "";
                switch (s) {
                    case 1:
                        pSpecie = "CANINO";
                        break;
                    case 2:
                        pSpecie = "FELINO";
                        break;
                    default:
                        System.out.println("LA OPCION NO ES CORRECTA");
                }
                System.out.println("escoja el sexo \n" + "1. HEMBRA\n" + "2. MACHO");
                int sex = read.nextInt();
                String pSex = "";
                switch (sex) {
                    case 1:
                        pSex = "HEMBRA";
                        break;
                    case 2:
                        pSex = "MACHO";
                        break;
                    default:
                        System.out.println("LA OPCION NO ES CORRECTA");
                }
                System.out.println("escoja el tamaño \n" + "1. MINIATURA\n" + "2. PEQUEÑO\n" + "3. MEDIANO\n" + "4. GRANDE");
                int size = read.nextInt();
                String pSize = "";
                switch (size) {
                    case 1:
                        pSize = "MINIATURA";
                        break;
                    case 2:
                        pSize = "PEQUEÑO";
                        break;
                    case 3:
                        pSize = "MEDIANO";
                        break;
                    case 4:
                        pSize = "GRANDE";
                        break;
                    default:
                        System.out.println("LA OPCION NO ES CORRECTA");
                }
                System.out.println("el animal es peligroso? \n" + "1. NO\n" + "2. SI");
                int danger = read.nextInt();
                String pDanger = "";
                switch (danger) {
                    case 1:
                        pDanger = "NO";
                        break;
                    case 2:
                        pDanger = "SI";
                        break;
                    default:
                        System.out.println("LA OPCION NO ES CORRECTA");
                }
                message = findByMultipleFields(pSpecie, pSex, pSize, pDanger);
                System.out.println(message);
                System.out.println("\nquiere seguir en el programa?\n" + "1. Si\n" + "2. No");
                int exit4 = read.nextInt();
                switch (exit4) {
                    case 1:
                        run();
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("LA OPCION NO ES CORRECTA");
                }
                break;

            default:

                break;
        }
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

            br = new BufferedReader(new FileReader("src/edu/unbosque/fourpawscitizens/model/data/pets-citizens.csv"));
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

    private String findByMicrochip(String pMicrochip) {
        String message = "";
        try {
            for (int i = 0; i < listOfPet.size(); i++) {

                if (Long.parseLong(pMicrochip) == listOfPet.get(i).getMicrochip()) {
                    message += "\nID: " + listOfPet.get(i).getId() + "\n" + "Species: " + listOfPet.get(i).getSpecies() + "\n"
                            + "Gender: " + listOfPet.get(i).getSex() + "\n" + "Size: " + listOfPet.get(i).getSize() + "\n" + "Potentially dangerous: " + listOfPet.get(i).getPotentDangerous() + "\n" + "Neighborhood: " + listOfPet.get(i).getNeighborhood() + "\n";
                }

            }

        } catch (Exception e) {
            System.out.println("Error, not found microchip");
        }
        return message;
    }

    private String countBySpecies(String pSpecie) {
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

    public String findBypotentDangerousInNeighborhood(int n, String option, String neighborhood) {
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

    public String findByMultipleFields(String species, String sex, String size, String potentDangerous) {
        String message = "";
        String pSize = "";
        if (size.equals("MINIATURA")) {
            pSize = size.substring(0, 2);
        } else {
            pSize = size.substring(0, 1);
        }
        String pSex = sex.substring(0, 1).toUpperCase();
        String pSpecies = species.substring(0, 1).toUpperCase();
        String pDangerous = "";
        if (potentDangerous.equals("NO")) {
            pDangerous = "F";
        } else if (potentDangerous.equals("SI")) {
            pDangerous = "T";
        }
        String aux = pSpecies + pSex + pSize + pDangerous;
        for (int i = 0; i < listOfPet.size(); i++) {
            String comparison = listOfPet.get(i).getId();
            String[] code = comparison.split("-");
            String res = code[1];
            if (res.equals(aux)) {
                message += this.listOfPet.get(i).getId() + "\n";
            }
        }
        return message;
    }
}