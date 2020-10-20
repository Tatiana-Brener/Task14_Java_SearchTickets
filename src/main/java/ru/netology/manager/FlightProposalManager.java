package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.FlightProposal;
import ru.netology.repository.FlightProposalRepository;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor

public class FlightProposalManager {
    private FlightProposalRepository repository;

    public FlightProposal[] findAll(String from, String to) {
        FlightProposal[] result = new FlightProposal[0];

        for (FlightProposal proposal : repository.getAllFlightProposal()) {
            if (proposal.matches(from, to)) {
                FlightProposal[] tmp = new FlightProposal[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = proposal;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
