package com.chocs.generics;

import java.util.Random;

public class Cpf {

    private byte stateDecodify(String state) {
        return switch (state) {
            case "DF", "TO", "MT", "MS", "GO" -> 1;
            case "AC", "RR", "RO", "PA", "AP", "AM" -> 2;
            case "CE", "MA", "PI" -> 3;
            case "PE", "RN", "PB", "AL" -> 4;
            case "BA", "SE" -> 5;
            case "MG" -> 6;
            case "ES", "RJ" -> 7;
            case "SP" -> 8;
            case "PR", "SC" -> 9;
            case "RS" -> 0;
            default -> -1;
        };
    }
    private void updater(byte[] cpf, int dv, byte num) {
        if (dv < 2)
            cpf[num] = 0;
        else
            cpf[num] = (byte) (11 - dv);
    }

    private int dvCalculator(byte[] cpf, int lim) {
        int dv = 0;

        for (byte i = 0; i < lim; i++) {
            dv += cpf[i] * (lim + 1 - i);
        }
        dv %= 11;

        return dv;
    }

    public byte[] generator(byte[] cpf, String state) {
        Random rand = new Random();

        for (byte i = 0; i < 9; i++) {
            if(i == 8) {
                cpf[i] = stateDecodify(state);
                continue;
            }
            cpf[i] = (byte) rand.nextInt(10);
        }
        updater(cpf, dvCalculator(cpf, 9), (byte) 9);
        updater(cpf, dvCalculator(cpf, 10), (byte) 10);

        return cpf;
    }

    public static void print(byte[] cpf) {
        System.out.print("CPF: ");
        for (byte i = 0; i < 11; i++) {
            if (i == 3 || i == 6)
                System.out.print(".");
            if (i == 9)
                System.out.print("-");

            System.out.print(cpf[i]);
        }
    }
}
