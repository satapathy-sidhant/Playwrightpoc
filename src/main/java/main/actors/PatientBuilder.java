package main.actors;

import java.util.function.Supplier;

public class PatientBuilder implements Actors<Patient> {

    private Patient p;

    private PatientBuilder(Patient patient) {
        this.p = patient;
    }

    public static PatientBuilder newPatient(Supplier<Patient> p) {
        return new PatientBuilder(p.get());
    }

    public PatientBuilder withName(String fname, String lname) {
        p.setFirstName(fname);
        p.setLastName(lname);
        return this;
    }

    public PatientBuilder havingMrn(String mrn) {
        p.setMrn(mrn);
        return this;
    }

    public PatientBuilder withPmsId(String pmsId) {
        p.setPmsId(pmsId);
        return this;
    }

    @Override
    public Patient build() {
        return p;
    }
}
