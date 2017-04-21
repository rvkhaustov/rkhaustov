package ru.job4j.prof;

/**
 * Created by rvkha_000 on 20.04.2017.
 * @version 1.0
 */
public class Profession {
    /**
     * @param edication - образование.
     */
    private String edication;
    /**
     * @param speciality - специальность.
     */
    private  String specialty;
    /**
     * @param nameFIO - ФИО
     */
    private String nameFIO;
    /**
     * construct.
     */
    public Profession() {

    }
    /**
     * @param edication - образование.
     * @param speciality образование.
     */
    public Profession(String edication, String speciality) {
        this.edication = edication;
        this.specialty = speciality;
    }

    /**
     * getEdication.
     * @return edication
     */
    public String getEdication() {
        return this.edication;
    }

    /**
     *
     * @return specialty
     */
    public String getSpecialty() {
        return this.specialty;
    }

    /**
     *
     * @param nameFIO фио
     */
    public void setNameFIO(String nameFIO) {
        this.nameFIO = nameFIO;
    }

    /**
     *
     * @return фио
     */
    public String getNameFIO() {
        return nameFIO;
    }
    //    public void Work() {
//
//    }

}
