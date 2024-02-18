package com.chocs.generics;

public class Person {
    protected String name = "";
    protected byte age;
    protected String state = "";
    protected byte[] cpf = new byte[11];

    public void insertName(String newName) {
        name = newName;
    }

    public void insertAge(byte newAge) {
        age = newAge;
    }

    public void insertState(String newState) {
        state = newState;
    }

    public void generateCpf(byte[] cpf) {
        Cpf cpfC = new Cpf();
        cpf = cpfC.generator(cpf, state);
    }
}