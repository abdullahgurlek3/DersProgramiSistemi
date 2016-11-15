/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */

public class ChartComponent {

    private final String name;

    public ChartComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isName(String s) {
        return true;
    }

}
