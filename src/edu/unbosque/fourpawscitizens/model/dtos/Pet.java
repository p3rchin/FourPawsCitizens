/**
 * Is the package that contains the classes.
 */

package edu.unbosque.fourpawscitizens.model.dtos;

public class Pet {

    /**
     * id is the String value
     */

    private String id;

    /**
     * microchip is the long value
     */

    private long microchip;

    /**
     * species is the String value
     */

    private String species;

    /**
     * sex is the String value
     */

    private String sex;

    /**
     * size is the String value
     */

    private String size;

    /**
     * potentDangerous is the boolean value
     */

    private boolean potentDangerous;

    /**
     * neighborhood is the String value
     */

    private String neighborhood;

    /**
     * This method creates the object Pet.
     */

    public Pet() {

    }

    /**
     * This method creates the object pet with attributes.
     * <b>pre</b> The object have had to be defined.<br>
     * <b>post</b> All the attributes must being refilled.<br>
     * @param id is the id of the pet: need to be != null and != " ".
     * @param microchip is the microchip of the pet: need to be != 0;
     * @param species is the species of the pet: need to be != null and != " ".
     * @param sex is the sex of the pet: need to be != null and != " ".
     * @param size is the size of the pet: need to be != null and != " ".
     * @param potentDangerous is the boolean of the pet: need to be a boolean value.
     * @param neighborhood is the neighborhood of the pet: need to be != null and != " ".
     */

    public Pet(String id, Long microchip, String species, String sex, String size, boolean potentDangerous, String neighborhood) {

        this.id = id;
        this.microchip = microchip;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.potentDangerous = potentDangerous;
        this.neighborhood = neighborhood;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getMicrochip() {
        return microchip;
    }

    public void setMicrochip(long microchip) {
        this.microchip = microchip;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean getPotentDangerous() {
        return potentDangerous;
    }

    public void setPotentDangerous(boolean potentDangerous) {
        this.potentDangerous = potentDangerous;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
