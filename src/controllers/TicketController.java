package controllers;

import dtos.ResponseStatus;
import dtos.TicketIssueRequestDto;
import dtos.TicketIssueResponseDto;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketIssueResponseDto issueTicket(TicketIssueRequestDto requestDto){
        TicketIssueResponseDto response = new TicketIssueResponseDto();
        try {
            Ticket ticket = ticketService.issueTicket(requestDto);
            response.setTicketId(ticket.getId());
            response.setTicketNumber(ticket.getTicketNumber());
            response.setStatus(ResponseStatus.SUCCESS);
        }catch (Exception exception){
            response.setStatus(ResponseStatus.FAILURE);
        }

        return response;

    }
}
