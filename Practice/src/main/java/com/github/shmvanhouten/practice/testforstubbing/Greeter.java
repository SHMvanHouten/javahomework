package com.github.shmvanhouten.practice.testforstubbing;

public class Greeter {
    private NameGetter nameGetter;

    public Greeter(NameGetter nameGetter) {
        this.nameGetter = nameGetter;
    }

    public String greet(String inputName){
        String name = nameGetter.getName(inputName);
        return "Hello " + name;
    }
}
