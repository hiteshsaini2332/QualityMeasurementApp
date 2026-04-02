package org.example.uc15;

public class Service {
    private final Repository repo;

    public Service(Repository repo) {
        this.repo = repo;
    }

    private Object getUnit(String u) {
        try { return LengthUnit.valueOf(u); } catch (Exception ignored) {}
        try { return WeightUnit.valueOf(u); } catch (Exception ignored) {}
        try { return VolumeUnit.valueOf(u); } catch (Exception ignored) {}
        try { return TemperatureUnit.valueOf(u); } catch (Exception ignored) {}

        throw new RuntimeException("Invalid unit");
    }

    public boolean compare(QuantityDTO a, QuantityDTO b) {
        Quantity q1 = new Quantity(a.value, (IMeasurable) getUnit(a.unit));
        Quantity q2 = new Quantity(b.value, (IMeasurable) getUnit(b.unit));

        boolean res = q1.equals(q2);
        repo.save(new QuantityEntity("COMPARE", String.valueOf(res)));
        return res;
    }

    public QuantityDTO convert(QuantityDTO q, String target) {
        Quantity obj = new Quantity(q.value, (IMeasurable) getUnit(q.unit));
        Quantity res = obj.convertTo((IMeasurable) getUnit(target));

        repo.save(new QuantityEntity("CONVERT", res.getValue() + " " + target));
        return new QuantityDTO(res.getValue(), target);
    }

    public QuantityDTO add(QuantityDTO a, QuantityDTO b) {
        Quantity q1 = new Quantity(a.value, (IMeasurable) getUnit(a.unit));
        Quantity q2 = new Quantity(b.value, (IMeasurable) getUnit(b.unit));

        Quantity res = q1.add(q2);

        repo.save(new QuantityEntity("ADD", res.getValue() + " " + res.getUnit()));
        return new QuantityDTO(res.getValue(), res.getUnit().toString());
    }
}
