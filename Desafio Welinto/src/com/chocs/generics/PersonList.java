package com.chocs.generics;

public class PersonList {
    Person[] people = new Person[7];

    public PersonList() {
        people[0] = new Person();
        people[1] = new Person();
        people[2] = new Person();
        people[3] = new Person();
        people[4] = new Person();
        people[5] = new Person();
        people[6] = new Person();
    }

    private void insertNames() {
        people[0].insertName("Fernando");
        people[1].insertName("Wellinto");
        people[2].insertName("Guliano");
        people[3].insertName("Lucas Santi!!!");
        people[4].insertName("Leandro");
        people[5].insertName("Romaldo Robens de Férias");
        people[6].insertName("Dirceu Ramiro das Dores");
    }

    private void insertAges() {
        people[0].insertAge((byte)55);
        people[1].insertAge((byte)18);
        people[2].insertAge((byte)99);
        people[3].insertAge((byte)-23);
        people[4].insertAge((byte)5);
        people[5].insertAge((byte)125);
        people[6].insertAge((byte)89);
    }

    private void insertStates() {
        people[0].insertState("MG");
        people[1].insertState("ES");
        people[2].insertState("PR");
        people[3].insertState("RR");
        people[4].insertState("MA");
        people[5].insertState("SC");
        people[6].insertState("AL");
    }

    private void generateCpf() {
        for (Person person : people) {
            person.generateCpf(person.cpf);
        }
    }

    public void printPerson() {
        insertNames();
        insertAges();
        insertStates();
        generateCpf();

        for (Person person : people) {
            System.out.printf("\n===== %s =====\n", person.name);
            System.out.println("Nome: " + person.name);
            System.out.println("Idade: " + person.age);
            System.out.println("Estado: " + person.state);
            Cpf.print(person.cpf);
            System.out.println();
        }
    }
}