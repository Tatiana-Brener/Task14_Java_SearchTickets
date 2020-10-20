package ru.netology.comparator;

import ru.netology.domain.FlightProposal;

import java.util.Comparator;

public class ProposalByTimeComparator implements Comparator<FlightProposal> {

    @Override
    public int compare(FlightProposal o1, FlightProposal o2) {
        return o1.getFlightTimeMin() - o2.getFlightTimeMin();
    }
}
