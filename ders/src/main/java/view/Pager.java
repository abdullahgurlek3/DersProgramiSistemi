/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.HashMap;
import java.util.Set;
import view.exception.PagerLimitException;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
public class Pager {

    private int page = 1;
    private Integer next;
    private Integer prev;

    private Integer start;
    private Integer end;

    private int max;

    private int min = 1;

    private Long allCount;

    private float size = 6;

    public void setPage(int page) {
        this.page = page;
    }

    public void setAllCountWithSysten(Long allCount) {
        this.allCount = allCount;
    }

    public int getPage() {
        return page;
    }

    public int getNext() {
        return next;
    }

    public int getPrev() {
        return prev;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public Long getAllCount() {
        return allCount;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public float getSize() {
        return size;
    }

    public void calculate() {

        double allOfCurrentPost = (page - 1) * size;

        if (allOfCurrentPost > allCount) {
            throw new PagerLimitException("Sayfa limiti aşırı fazla");
        }

        if (page < 1) {
            throw new PagerLimitException("Sayfa limiti - olamaz");
        }

        float doublemax;
        float doublemin;

        doublemax = ((allCount / size));

        end = (int) (doublemax + 1);
        if (end - 1 == doublemax) {
            end = (int) (doublemax);
        }

        doublemin = doublemax - size + 1;

        if (doublemin < 1) {
            doublemin = 1;
        }

        if (doublemin > page) {
            doublemin = page;
            doublemax = page + size;
        }

        min = (int) doublemin;
        max = (int) (doublemax + 1);

        if (max - 1 == doublemax) {
            max = (int) doublemax;
        }

        prev = page - 1;
        next = page + 1;

        if (prev < 1) {
            prev = null;
        }

        if (next >= max) {
            next = null;
        }

        if (end == page) {
            end = null;
        }

        if (page >= size) {
            start = 1;
        }

    }

    public String getPagerText(String replaceText, String href, HashMap<String, String> parameterMap) {

        String parameterText;
        if (parameterMap.isEmpty()) {
            parameterText = "?";
        } else {
            parameterText = "?";
            Set<String> keyset = parameterMap.keySet();
            for (String keyset1 : keyset) {
                parameterText += keyset1 + "=" + parameterMap.get(keyset1) + "&";
            }
        }
        if (start != null) {
            replaceText = replaceText.replace("{start}", "");//"<li><a href=\"" + href + parameterText + "page=" + start + "\">" + start + "</a></li>");
        } else {
            replaceText = replaceText.replace("{start}", "");
        }

        if (prev != null) {
            replaceText = replaceText.replace("{prev}", "<li><a href=\"" + href + parameterText + "page=" + prev + "\">" + prev + "</a></li>");
        } else {
            replaceText = replaceText.replace("{prev}", "");
        }

        if (next != null) {
            replaceText = replaceText.replace("{next}", "<li><a href=\"" + href + parameterText + "page=" + next + "\">" + next + "</a></li>");
        } else {
            replaceText = replaceText.replace("{next}", "");
        }

        if (end != null) {
            replaceText = replaceText.replace("{end}", "<li><a href=\"" + href + parameterText + "page=" + end + "\">" + end + "</a></li>");
        } else {
            replaceText = replaceText.replace("{end}", "");
        }

        StringBuilder numbers = new StringBuilder();
        for (int i = min; i <= max; i++) {
            if (i == page) {
                numbers.append("<li class=\"active\"><a href=\"#\">" + i + "</a></li>");
            } else {
                numbers.append("<li><a href='" + parameterText + "page=" + i + "'>" + i + "</a></li>");
            }
        }

        replaceText = replaceText.replace("{numbers}", numbers.toString());

        return replaceText;
    }

}
