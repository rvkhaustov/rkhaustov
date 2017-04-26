package ru.rkhaustov.prof;

/**
 * Created by rvkha_000 on 20.04.2017.
 * @version 1.0
 */
public class Doctor extends Profession {
    /**
     * @param medicalDirection - медецинское направление
     */
    private String medicalDirection;

    /**
     *
     * @param medicalDirection медецинское направление
     */
    public void setMedicalDirection(String medicalDirection) {
        this.medicalDirection = medicalDirection;
    }


    /**
     *
     * @return медецинское направление
     */
    public String getMedicalDirection() {
        return medicalDirection;
    }
    /**
     *
     * @param pacient - пациент
     * @return diagnose
     */
    public Diagnose heal(Pacient pacient) {
        Diagnose diagnose = new Diagnose();
        diagnose.setDiagnose("Доктор " + getNameFIO() + " лечит " + pacient.getNameFIO());
        return diagnose;
    }
}
