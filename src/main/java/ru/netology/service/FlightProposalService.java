package ru.netology.service;

import ru.netology.domain.FlightProposal;
import ru.netology.repository.FlightProposalRepository;

import java.util.Arrays;
import java.util.Comparator;

public class FlightProposalService {
    private FlightProposalRepository repository;

    public FlightProposal[] findAll(String from, String to, Comparator<FlightProposal> comparator) {
        FlightProposal[] result = new FlightProposal[0];

        for (FlightProposal proposal : repository.getAllFlightProposal()) {
            if (proposal.matches(from, to)) {
                FlightProposal[] tmp = new FlightProposal[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = proposal;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}
