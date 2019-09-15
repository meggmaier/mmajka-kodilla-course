import com.kodilla.good.patterns.challenges.flights.Airport;
import com.kodilla.good.patterns.challenges.flights.FlightSearcher;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FlightSearcherTestSuite {


    private List<Pair> flights = new ArrayList<>();

    private Airport pzn;
    private Airport wawa;
    private Airport krk;
    private Airport wrc;

    FlightSearcher flightSearcher;

    @Before
    public void prepare(){
        pzn = new Airport("Poznań");
        wawa = new Airport("Warszawa");
        krk = new Airport("Kraków");
        wrc = new Airport("Wrocław");

        ImmutablePair<Airport, Airport> pznWrc = new ImmutablePair<>(pzn, wrc);
        ImmutablePair<Airport, Airport> wawaKrk = new ImmutablePair<>(wawa, krk);
        ImmutablePair<Airport, Airport> wawaWrc = new ImmutablePair<>(wawa, wrc);
        ImmutablePair<Airport, Airport> wrcWawa = new ImmutablePair<>(wrc, wawa);
        ImmutablePair<Airport, Airport> krkWrc = new ImmutablePair<>(krk, wrc);
        ImmutablePair<Airport, Airport> pznWawa = new ImmutablePair<>(pzn, wawa);

        flights.add(pznWrc);
        flights.add(wawaKrk);
        flights.add(wawaWrc);
        flights.add(wrcWawa);
        flights.add(krkWrc);
        flights.add(pznWawa);

        flightSearcher = new FlightSearcher(flights);
    }

    @Test
    public void testSearchAllArrivals(){
        //Given

        //When
        List<Object> testList = flightSearcher.searchAllArrivals(wawa);
        System.out.println(testList);

        //Then
        Assert.assertEquals(2, testList.size());
    }

    @Test
    public void testSearchAllDepartures(){
        //Given

        //When
        List<Object> testList = flightSearcher.searchAllDepartures(wawa);
        System.out.println(testList);

        //Then
        Assert.assertEquals(2, testList.size());
    }

    @Test
    public void testGetDirectConnection(){
        //Given
        ImmutablePair<Airport, Airport> pznWawa = new ImmutablePair<>(pzn, wawa);
        List<Pair> expectedDirectMap = new ArrayList<>();
        expectedDirectMap.add(pznWawa);

        //When
        List<Pair> testMap = flightSearcher.getConnection(pzn, wawa);

        //Then
        Assert.assertEquals(expectedDirectMap, testMap);
    }

    @Test
    public void testGetNonDirectConnection(){
        //Given
        ImmutablePair<Airport, Airport> wawaKrk = new ImmutablePair<>(wawa, krk);
        ImmutablePair<Airport, Airport> pznWawa = new ImmutablePair<>(pzn, wawa);
        List<Pair> expectedNonDirectMap = new ArrayList<>();

        expectedNonDirectMap.add(pznWawa);
        expectedNonDirectMap.add(wawaKrk);

        //When
        List<Pair> testMap1 = flightSearcher.getConnection(pzn, krk);
        System.out.println(testMap1);

        //Then
        Assert.assertEquals(expectedNonDirectMap, testMap1);
    }
}
