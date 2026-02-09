package org.example.lld.parkingLot.invoice;

import org.example.lld.parkingLot.Ticket.*;

public class Invoice {
    long amount;
    Ticket ticket;

    @Override
    public String toString() {
        return "Invoice{" +
                "amount=" + amount +
                ", ticket=" + ticket +
                '}';
    }

    public Invoice(Ticket ticket, long amount ) {
        this.amount = amount;
        this.ticket = ticket;
    }
}
