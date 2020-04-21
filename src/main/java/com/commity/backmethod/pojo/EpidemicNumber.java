package com.commity.backmethod.pojo;

import org.springframework.stereotype.Component;

@Component
public class EpidemicNumber {
    private  Integer coughNumber;//咳嗽人员
    private  Integer shortBreathNumber;//气促人员
    private  Integer goDoctorNumber;//就医人员
    private  Integer quarantineNumber;//隔离人员
    private  Integer diagnosisNumber;//确诊人数
    private  Integer suspectedNumber;//疑似人数
    private  Integer goDoctorAndDiagnosisNumber;//就医并确诊人数
    public Integer getCoughNumber() {
        return coughNumber;
    }
    public void setCoughNumber(Integer coughNumber) {
        this.coughNumber = coughNumber;
    }

    public Integer getShortBreathNumber() {
        return shortBreathNumber;
    }

    public void setShortBreathNumber(Integer shortBreathNumber) {
        this.shortBreathNumber = shortBreathNumber;
    }

    public Integer getGoDoctorNumber() {
        return goDoctorNumber;
    }

    public void setGoDoctorNumber(Integer goDoctorNumber) {
        this.goDoctorNumber = goDoctorNumber;
    }

    public Integer getQuarantineNumber() {
        return quarantineNumber;
    }

    public void setQuarantineNumber(Integer quarantineNumber) {
        this.quarantineNumber = quarantineNumber;
    }

    public Integer getDiagnosisNumber() {
        return diagnosisNumber;
    }

    public void setDiagnosisNumber(Integer diagnosisNumber) {
        this.diagnosisNumber = diagnosisNumber;
    }

    public Integer getSuspectedNumber() {
        return suspectedNumber;
    }

    public void setSuspectedNumber(Integer suspectedNumber) {
        this.suspectedNumber = suspectedNumber;
    }

    public Integer getGoDoctorAndDiagnosisNumber() {
        return goDoctorAndDiagnosisNumber;
    }

    public void setGoDoctorAndDiagnosisNumber(Integer goDoctorAndDiagnosisNumber) {
        this.goDoctorAndDiagnosisNumber = goDoctorAndDiagnosisNumber;
    }

    @Override
    public String toString() {
        return "EpidemicNumber{" +
                "coughNumber=" + coughNumber +
                ", shortBreathNumber=" + shortBreathNumber +
                ", goDoctorNumber=" + goDoctorNumber +
                ", quarantineNumber=" + quarantineNumber +
                ", diagnosisNumber=" + diagnosisNumber +
                ", suspectedNumber=" + suspectedNumber +
                ", goDoctorAndDiagnosisNumber=" + goDoctorAndDiagnosisNumber +
                '}';
    }
}
