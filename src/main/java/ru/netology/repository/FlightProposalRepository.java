package ru.netology.repository;

import ru.netology.domain.FlightProposal;
import ru.netology.exeption.NotFoundException;

public class FlightProposalRepository {
    private FlightProposal[] proposals = new FlightProposal[0];

    public void addFlightProposal(FlightProposal addedFlightProposal) {
        int length = proposals.length + 1;
        FlightProposal[] tmp = new FlightProposal[length];
        System.arraycopy(proposals, 0, tmp, 0, proposals.length);

        int lastFlightProposalsIndex = tmp.length - 1;
        tmp[lastFlightProposalsIndex] = addedFlightProposal;
        proposals = tmp;
    }

    public FlightProposal[] getAllFlightProposal() {
        return proposals;
    }

    public FlightProposal findById(int id) {
        for (FlightProposal proposal : proposals) {
            if (proposal.getId() == id) {
                return proposal;
            }
        }
        return null;
    }

    public void removeById(int idToRemove) throws NotFoundException {
        if (findById(idToRemove) != null) {
            int length = proposals.length - 1;
            FlightProposal[] tmp = new FlightProposal[length];
            int index = 0;
            for (FlightProposal proposal : proposals) {
                if (proposal.getId() != idToRemove) {
                    tmp[index] = proposal;
                    index++;
                }
            }
            proposals = tmp;
        } else {
            throw new NotFoundException("Flight proposals with id: " + idToRemove + " not found");
        }
    }
}
