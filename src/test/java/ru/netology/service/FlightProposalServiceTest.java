package ru.netology.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.comparator.ProposalByTimeComparator;
import ru.netology.domain.FlightProposal;
import ru.netology.repository.FlightProposalRepository;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class FlightProposalServiceTest {

    @Mock
    private FlightProposalRepository repository;

    @InjectMocks
    private FlightProposalService proposalService;

    private FlightProposal firstProposal = new FlightProposal(1, 1900, "SVO", "AER", 150);
    private FlightProposal secondProposal = new FlightProposal(2, 2015, "DME", "AER", 145);
    private FlightProposal thirdProposal = new FlightProposal(3, 1785, "VKO", "AER", 138);
    private FlightProposal fourthProposal = new FlightProposal(4, 1850, "VKO", "AER", 132);
    private FlightProposal fifthProposal = new FlightProposal(5, 1795, "DME", "AER", 142);
    private FlightProposal sixthProposal = new FlightProposal(6, 1799, "VKO", "AER", 148);
    private FlightProposal seventhProposal = new FlightProposal(7, 2000, "DME", "AER", 130);
    private FlightProposal eighthProposal = new FlightProposal(8, 1850, "DME", "AER", 135);
    private FlightProposal ninthProposal = new FlightProposal(9, 1850, "SVO", "AER", 125);
    private FlightProposal tenthProposal = new FlightProposal(10, 1890, "SVO", "AER", 128);

    @Test
    public void shouldFindAllProposalsWithTimeComparator1() {
        String from = "svo";
        String to = "aer";
        Comparator<FlightProposal> comparator = new ProposalByTimeComparator();

        FlightProposal[] returned = new FlightProposal[]{firstProposal, secondProposal, thirdProposal, fourthProposal, fifthProposal,
                sixthProposal, seventhProposal, eighthProposal, ninthProposal, tenthProposal};

        doReturn(returned).when(repository).getAllFlightProposal();

        FlightProposal[] expected = new FlightProposal[]{ninthProposal, tenthProposal, firstProposal};
        FlightProposal[] actual = proposalService.findAll(from, to, comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllProposalsWithTimeComparator2() {
        String from = "vko";
        String to = "aer";
        Comparator<FlightProposal> comparator = new ProposalByTimeComparator();

        FlightProposal[] returned = new FlightProposal[]{firstProposal, secondProposal, thirdProposal, fourthProposal, fifthProposal,
                sixthProposal, seventhProposal, eighthProposal, ninthProposal, tenthProposal};

        doReturn(returned).when(repository).getAllFlightProposal();

        FlightProposal[] expected = new FlightProposal[]{fourthProposal, thirdProposal, sixthProposal};
        FlightProposal[] actual = proposalService.findAll(from, to, comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProposalsIfNotMatchedToRequest() {
        String from = "zki";
        String to = "aer";
        Comparator<FlightProposal> comparator = new ProposalByTimeComparator();

        FlightProposal[] returned = new FlightProposal[]{firstProposal, secondProposal, thirdProposal, fourthProposal, fifthProposal,
                sixthProposal, seventhProposal, eighthProposal, ninthProposal, tenthProposal};

        doReturn(returned).when(repository).getAllFlightProposal();

        FlightProposal[] expected = new FlightProposal[]{};
        FlightProposal[] actual = proposalService.findAll(from, to, comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProposalsIfAbsentFrom() {
        String from = "";
        String to = "aer";
        Comparator<FlightProposal> comparator = new ProposalByTimeComparator();

        FlightProposal[] returned = new FlightProposal[]{firstProposal, secondProposal, thirdProposal, fourthProposal, fifthProposal,
                sixthProposal, seventhProposal, eighthProposal, ninthProposal, tenthProposal};

        doReturn(returned).when(repository).getAllFlightProposal();

        FlightProposal[] expected = new FlightProposal[]{};
        FlightProposal[] actual = proposalService.findAll(from, to, comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProposalsIfAbsentTo() {
        String from = "svo";
        String to = "";
        Comparator<FlightProposal> comparator = new ProposalByTimeComparator();

        FlightProposal[] returned = new FlightProposal[]{firstProposal, secondProposal, thirdProposal, fourthProposal, fifthProposal,
                sixthProposal, seventhProposal, eighthProposal, ninthProposal, tenthProposal};

        doReturn(returned).when(repository).getAllFlightProposal();

        FlightProposal[] expected = new FlightProposal[]{};
        FlightProposal[] actual = proposalService.findAll(from, to, comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindProposalsIfAbsentFromAndTo() {
        String from = "";
        String to = "";
        Comparator<FlightProposal> comparator = new ProposalByTimeComparator();

        FlightProposal[] returned = new FlightProposal[]{firstProposal, secondProposal, thirdProposal, fourthProposal, fifthProposal,
                sixthProposal, seventhProposal, eighthProposal, ninthProposal, tenthProposal};

        doReturn(returned).when(repository).getAllFlightProposal();

        FlightProposal[] expected = new FlightProposal[]{};
        FlightProposal[] actual = proposalService.findAll(from, to, comparator);

        assertArrayEquals(expected, actual);
    }
}
