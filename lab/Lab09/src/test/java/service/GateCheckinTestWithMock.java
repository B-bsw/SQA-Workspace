package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sqa.lab.service.GateCheckin;
import sqa.lab.service.TicketCounter;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GateCheckinTestWithMock {
    private TicketCounter ticketCounter;
    private GateCheckin gateCheckin;

    @BeforeEach
    void setUp() {
        ticketCounter = mock(TicketCounter.class);
        gateCheckin = new GateCheckin(ticketCounter);
    }

    @Test
    void checkGateCheckinNumberOfCustomer() {
        gateCheckin.customerEntry(11);
        gateCheckin.customerEntry(22);
        gateCheckin.customerEntry(22);

        verify(ticketCounter,times(2)).changeTicketStatus(true);
        assertEquals(2, gateCheckin.getPassengersOnBoard().size());
    }
}
