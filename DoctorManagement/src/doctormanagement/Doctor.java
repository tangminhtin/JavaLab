/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormanagement;

/**
 *
 * @author tangminhtin CE130438
 */
public class Doctor {

    private String code;    // Store code of doctor
    private String name;    // Store name of doctor
    private String specialization; // Store specialization of doctor
    private int availability;   // Store availability of doctor

    /**
     * Create constructor for doctor
     *
     * @param code
     * @param name
     * @param specialization
     * @param availability
     */
    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    /**
     * Gets code of doctor
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code of doctor
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets name of doctor
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of doctor
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets specialization of doctor
     *
     * @return
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Sets specialization of doctor
     *
     * @param specialization
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Gets availability of doctor
     *
     * @return
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Sets availability of doctor
     *
     * @param availability
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     * Override method toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return "Doctor{" + "code=" + code + ", name=" + name + ", specialization=" + specialization + ", availability=" + availability + '}';
    }

}
