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
public enum Hours {

    HOUR_6(false),
    HOUR_7(false),
    HOUR_8(true),
    HOUR_9(true),
    HOUR_10(true),
    HOUR_11(true),
    HOUR_12(false),
    HOUR_13(true),
    HOUR_14(true),
    HOUR_15(true),
    HOUR_16(true),
    HOUR_17(false),
    HOUR_18(false),
    HOUR_19(false),
    HOUR_20(false);
    private boolean mesai;

    private Hours(boolean mesai) {
        this.mesai = mesai;
    }

    public boolean isMesai() {
        return mesai;
    }

    public void setMesai(boolean mesai) {
        this.mesai = mesai;
    }

}
