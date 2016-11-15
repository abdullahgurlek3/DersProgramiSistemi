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
public class Order {

    public String orderName = "id";
    public String orderType = "desc";

    public org.hibernate.criterion.Order getOrder() {
        if (orderType.equals("asc")) {
            return org.hibernate.criterion.Order.asc(orderName);
        } else {
            return org.hibernate.criterion.Order.desc(orderName);
        }
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

}
