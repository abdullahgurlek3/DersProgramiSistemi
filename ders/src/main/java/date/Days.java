/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
public enum Days {

    PAZARTESI(true),
    SALI(true),
    CARSAMBA(true),
    PERSEMBE(true),
    CUMA(true),
    CUMARTESI(false),
    PAZAR(false);

    private boolean mesai;

    private Days(boolean mesai) {
        this.mesai = mesai;
    }

    public boolean isMesai() {
        return mesai;
    }

    public void setMesai(boolean mesai) {
        this.mesai = mesai;
    }

}
