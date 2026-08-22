package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sqa.lab.service.SeatDAO;
import sqa.lab.service.SeatReservation;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SeatReservationTestWithMock {

    private SeatDAO seatDAO;
    private SeatReservation seatReservation;

    @BeforeEach
    void setUp() throws SQLException {
        seatDAO = mock(SeatDAO.class);
        seatReservation = new SeatReservation(seatDAO);

        List<String> availableSeats = List.of("A1");
        when(seatDAO.fetchAvailableSeats()).thenReturn(availableSeats);
    }

    @Test
    void checkSeatReservationValid() throws SQLException {
        assertTrue(seatReservation.checkSeatAvailability("A1"));
    }
    @Test
    void checkSeatReservationInvalid() throws SQLException {
        assertFalse(seatReservation.checkSeatAvailability("A2"));
    }
}
