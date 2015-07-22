/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jensheuschkel.jstickynote.app;

import java.util.Random;

/**
 *
 * @author Jens
 */
public class IdGenerator {

    public static String generateRandomId() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append(System.currentTimeMillis()).append("_")
                .append(Math.abs(rand.nextInt(99)));

        return sb.toString();
    }
}
