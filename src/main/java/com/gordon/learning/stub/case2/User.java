package com.gordon.learning.stub.case2;

public class User {
    private final long id;
    private final String firstName;
    private final String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}
