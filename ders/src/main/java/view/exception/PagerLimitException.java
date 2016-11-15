/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.exception;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
public class PagerLimitException extends RuntimeException {

    public PagerLimitException(String sayfa_limiti__olamaz) {
        super(sayfa_limiti__olamaz);
    }

}
