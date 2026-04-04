import org.example.uc15.exception.*;
import org.example.uc15.exception.QuantityMeasurementExceptionUC15;
import org.example.uc15.repo.QuantityMeasurementRepositoryUC15;
import org.example.uc15.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.example.uc15.dto.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuantityMeasurementAppTestUC15 {
    private final IQuantityMeasurementServiceUC15 service =
            new QuantityMeasurementServiceImplUC15(
                    new QuantityMeasurementRepositoryUC15()
            );

    private final GlobalExceptionHandlerUC15 handler =
            new GlobalExceptionHandlerUC15();

    //  DTO TESTS
    @Test
    void testDTOCreation() {
        QuantityDTOUC15 dto = new QuantityDTOUC15(10, "KG", "WEIGHT");

        assertEquals(10, dto.getValue());
        assertEquals("KG", dto.getUnitName());
        assertEquals("WEIGHT", dto.getMeasurementType());
    }



    @Test
    void testAdd_DifferentMeasurementType_ShouldThrow() {
        QuantityDTOUC15 q1 = new QuantityDTOUC15(10, "KG", "WEIGHT");
        QuantityDTOUC15 q2 = new QuantityDTOUC15(5, "FEET", "LENGTH");

        assertThrows(QuantityMeasurementExceptionUC15.class,
                () -> service.add(q1, q2));
    }

    @Test
    void testAdd_NullInput_ShouldThrow() {
        assertThrows(QuantityMeasurementExceptionUC15.class,
                () -> service.add(null, null));
    }


    @Test
    void testConvert_NullInput_ShouldThrow() {
        assertThrows(QuantityMeasurementExceptionUC15.class,
                () -> service.convert(null, "KG"));
    }




    // EXCEPTION HANDLER TESTS

    @Test
    void testHandleDomainException() {
        QuantityMeasurementExceptionUC15 ex =
                new QuantityMeasurementExceptionUC15("Error");

        ResponseEntity<String> response =
                handler.handleDomainException(ex);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Error", response.getBody());
    }

    @Test
    void testHandleGenericException() {
        Exception ex = new Exception();

        ResponseEntity<String> response =
                handler.handleGeneric(ex);

        assertEquals(500, response.getStatusCodeValue());
    }



}
