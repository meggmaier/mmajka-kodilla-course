import com.kodilla.good.patterns.challenges.flights.Airport;
import com.kodilla.good.patterns.challenges.flights.Connection;
import com.kodilla.good.patterns.challenges.flights.FlightSearcher;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FlightSearcherTestSuite {

    private List<Connection> flights = new ArrayList<>();

    private Airport pzn;
    private Airport wawa;
    private Airport krk;

    private FlightSearcher flightSearcher;

    @Before
    public void prepare(){
        pzn = new Airport("Poznań");
        wawa = new Airport("Warszawa");
        krk = new Airport("Kraków");
        Airport wrc = new Airport("Wrocław");

        Connection pznWrc = new Connection(pzn, wrc);
        Connection wawaKrk = new Connection(wawa, krk);
        Connection wawaWrc = new Connection(wawa, wrc);
        Connection wrcWawa = new Connection(wrc, wawa);
        Connection krkWrc = new Connection(krk, wrc);
        Connection pznWawa = new Connection(pzn, wawa);

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
        List<Airport> testList = flightSearcher.searchAllArrivals(wawa);
        System.out.println(testList);

        //Then
        Assert.assertEquals(2, testList.size());
    }

    @Test
    public void testSearchAllDepartures(){
        //Given

        //When
        List<Airport> testList = flightSearcher.searchAllDepartures(wawa);
        System.out.println(testList);

        //Then
        Assert.assertEquals(2, testList.size());
    }

    @Test
    public void testGetDirectConnection(){
        //Given
        Connection pznWawa = new Connection(pzn, wawa);
        List<Connection> expectedDirectMap = new ArrayList<>();
        expectedDirectMap.add(pznWawa);

        //When
        List<Connection> testMap = flightSearcher.getConnection(pzn, wawa, krk);

        //Then
        Assert.assertEquals(expectedDirectMap, testMap);
    }

    @Test
    public void testGetNonDirectConnection(){
        //Given
        Connection wawaKrk = new Connection(wawa, krk);
        Connection pznWawa = new Connection(pzn, wawa);
        List<Connection> expectedNonDirectMap = new ArrayList<>();

        expectedNonDirectMap.add(wawaKrk);
        expectedNonDirectMap.add(pznWawa);

        //When
        List<Connection> testMap1 = flightSearcher.getConnection(pzn, krk, wawa);
        System.out.println(testMap1);

        //Then
        Assert.assertEquals(expectedNonDirectMap, testMap1);
    }
}
