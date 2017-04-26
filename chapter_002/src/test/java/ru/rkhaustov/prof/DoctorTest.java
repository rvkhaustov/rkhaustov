package ru.rkhaustov.prof;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by rvkha_000 on 21.04.2017.
 */
public class DoctorTest {
    /**
     * Test Heal.
     */
    @Test
    public void  whenHealInputArgumentThenMessage() {
        Doctor doctor = new Doctor();
        doctor.setNameFIO("Roman");
        Pacient pacient = new Pacient();
        pacient.setNameFIO("Ivan");
        Diagnose diagnoseResult = new Diagnose();
        Diagnose diagnoseExpected = new Diagnose();
        diagnoseResult = doctor.heal(pacient);
        diagnoseExpected.setDiagnose("Доктор Roman лечит Ivan");
        assertThat(diagnoseResult.getDiagnose(), is(diagnoseExpected.getDiagnose()));


        //    public Diagnose heal(Pacient pacient) {} из класса Doctor возвращает
//    строку "Доктор Иван лечит Сергея", где Иван - это поле "name" доктора, а
//    Сергей - аргумент метода "pacient".


    }
}
