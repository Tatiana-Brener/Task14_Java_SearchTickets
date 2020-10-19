package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.FlightProposal;
import ru.netology.repository.FlightProposalRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)

class FlightProposalManagerTest {

    @Mock
    private FlightProposalRepository repository;

    @InjectMocks
    private FlightProposalManager proposalManager;

    private FlightProposal firstProposal = new FlightProposal(1, 1900, "SVO", "AER", 155);
    private FlightProposal secondProposal = new FlightProposal(2, 2015, "DME", "AER", 145);
    private FlightProposal thirdProposal = new FlightProposal(3, 1785, "VKO", "AER", 130);
    private FlightProposal fourthProposal = new FlightProposal(4, 1850, "VKO", "AER", 130);
    private FlightProposal fifthProposal = new FlightProposal(5, 1795, "DME", "AER", 145);
    private FlightProposal sixthProposal = new FlightProposal(6, 1799, "VKO", "AER", 140);
    private FlightProposal seventhProposal = new FlightProposal(7, 2000, "DME", "AER", 130);
    private FlightProposal eighthProposal = new FlightProposal(8, 1850, "DME", "AER", 130);
    private FlightProposal ninthProposal = new FlightProposal(9, 1850, "SVO", "AER", 130);
    private FlightProposal tenthProposal = new FlightProposal(10, 1890, "SVO", "AER", 130);

    @Test
    public void shouldFindAllProposalsIfMatchedToRequest1() {

        String from = "svo";
        String to = "aer";

        FlightProposal[] returned = new FlightProposal[] {firstProposal, secondProposal, thirdProposal, fourthProposal, fifthProposal,
                sixthProposal, seventhProposal, eighthProposal, ninthProposal, tenthProposal};

        doReturn(returned).when(repository).getAllFlightProposal();

        FlightProposal[] expected = new FlightProposal[] {ninthProposal, tenthProposal, firstProposal};
        FlightProposal[] actual = proposalManager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllProposalsIfMatchedToRequest2() {

        String from = "dme";
        String to = "aer";

        FlightProposal[] returned = new FlightProposal[] {firstProposal, secondProposal, thirdProposal, fourthProposal, fifthProposal,
                sixthProposal, seventhProposal,eighthProposal, ninthProposal, tenthProposal};

        doReturn(returned).when(repository).getAllFlightProposal();

        FlightProposal[] expected = new FlightProposal[] {fifthProposal, eighthProposal, seventhProposal, secondProposal};
        FlightProposal[] actual = proposalManager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProposalsIfNotMatchedToRequest() {

        String from = "zki";
        String to = "aer";

        FlightProposal[] returned = new FlightProposal[] {firstProposal, secondProposal, thirdProposal, fourthProposal, fifthProposal,
                sixthProposal, seventhProposal,eighthProposal, ninthProposal, tenthProposal};

        doReturn(returned).when(repository).getAllFlightProposal();

        FlightProposal[] expected = new FlightProposal[] {};
        FlightProposal[] actual = proposalManager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProposalsIfAbsentFrom() {

        String from = "";
        String to = "aer";

        FlightProposal[] returned = new FlightProposal[] {firstProposal, secondProposal, thirdProposal, fourthProposal, fifthProposal,
                sixthProposal, seventhProposal,eighthProposal, ninthProposal, tenthProposal};

        doReturn(returned).when(repository).getAllFlightProposal();

        FlightProposal[] expected = new FlightProposal[] {};
        FlightProposal[] actual = proposalManager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProposalsIfAbsentTo() {

        String from = "svo";
        String to = "";

        FlightProposal[] returned = new FlightProposal[] {firstProposal, secondProposal, thirdProposal, fourthProposal, fifthProposal,
                sixthProposal, seventhProposal,eighthProposal, ninthProposal, tenthProposal};

        doReturn(returned).when(repository).getAllFlightProposal();

        FlightProposal[] expected = new FlightProposal[] {};
        FlightProposal[] actual = proposalManager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProposalsIfAbsentFromAndTo() {

        String from = "";
        String to = "";

        FlightProposal[] returned = new FlightProposal[] {firstProposal, secondProposal, thirdProposal, fourthProposal, fifthProposal,
                sixthProposal, seventhProposal,eighthProposal, ninthProposal, tenthProposal};

        doReturn(returned).when(repository).getAllFlightProposal();

        FlightProposal[] expected = new FlightProposal[] {};
        FlightProposal[] actual = proposalManager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }
}