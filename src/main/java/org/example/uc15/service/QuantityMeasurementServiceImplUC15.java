package org.example.uc15.service;

import org.example.uc15.dto.QuantityDTOUC15;
import org.example.uc15.exception.QuantityMeasurementExceptionUC15;
import org.example.uc15.repo.*;
import org.example.uc15.entity.QuantityMeasurementEntity;

import org.springframework.stereotype.Service;

@Service
public class QuantityMeasurementServiceImplUC15 implements IQuantityMeasurementServiceUC15{
    private final QuantityMeasurementRepositoryUC15 repo;

    public QuantityMeasurementServiceImplUC15(QuantityMeasurementRepositoryUC15 repo) {
        this.repo = repo;
    }

    private double convertToBase(QuantityDTOUC15 dto) {
        switch (dto.getUnitName()) {
            case "FEET": return dto.getValue() * 12;
            case "INCHES": return dto.getValue();
            case "CENTIMETERS": return dto.getValue() * 0.3937;
            default: throw new QuantityMeasurementExceptionUC15("Invalid unit");
        }
    }

    private double convertFromBase(double value, String targetUnit) {
        switch (targetUnit) {
            case "FEET": return value / 12;
            case "INCHES": return value;
            case "CENTIMETERS": return value / 0.3937;
            default: throw new QuantityMeasurementExceptionUC15("Invalid target unit");
        }
    }

    @Override
    public QuantityDTOUC15 add(QuantityDTOUC15 first, QuantityDTOUC15 second) {

        if (!first.getMeasurementType().equals(second.getMeasurementType())) {
            throw new QuantityMeasurementExceptionUC15("Measurement type mismatch");
        }

        double base1 = convertToBase(first);
        double base2 = convertToBase(second);

        double resultBase = base1 + base2;

        double finalResult = convertFromBase(resultBase, first.getUnitName());

        repo.save(new QuantityMeasurementEntity(base1, base2, "ADD", finalResult));

        return new QuantityDTOUC15(finalResult, first.getUnitName(), first.getMeasurementType());
    }

    @Override
    public QuantityDTOUC15 convert(QuantityDTOUC15 dto, String targetUnit) {

        double base = convertToBase(dto);
        double result = convertFromBase(base, targetUnit);

        return new QuantityDTOUC15(result, targetUnit, dto.getMeasurementType());
    }
}
