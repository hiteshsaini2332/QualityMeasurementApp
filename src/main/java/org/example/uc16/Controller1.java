package org.example.uc16;

public class Controller1{
    private final Repository repository;

    public Controller1() {
        this.repository = Repository.getInstance();
    }

    public String getPoolStats() {
        return repository.getPoolStatistics();
    }
}
