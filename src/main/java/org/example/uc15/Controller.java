package org.example.uc15;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void compare(QuantityDTO a, QuantityDTO b) {
        System.out.println("Compare: " + service.compare(a, b));
    }

    public void convert(QuantityDTO q, String target) {
        QuantityDTO res = service.convert(q, target);
        System.out.println("Converted: " + res.value + " " + res.unit);
    }

    public void add(QuantityDTO a, QuantityDTO b) {
        QuantityDTO res = service.add(a, b);
        System.out.println("Added: " + res.value + " " + res.unit);
    }
}
