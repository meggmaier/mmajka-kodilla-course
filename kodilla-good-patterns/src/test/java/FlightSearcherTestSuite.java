import com.kodilla.good.patterns.challenges.flights.Airport;
import com.kodilla.good.patterns.challenges.flights.FlightSearcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlightSearcherTestSuite {

    private HashMap<Airport, Airport> flights = new HashMap<>();

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

        flights.put(pzn, wrc);
        flights.put(wawa, krk);
        flights.put(wawa, wrc);
        flights.put(wrc, wawa);
        flights.put(krk, wrc);
        flights.put(pzn, wawa);

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
    public void testHasDirectConnection(){
        //Given

        //When
        boolean hasDirect = flightSearcher.hasDirectConnection(pzn, wawa);
        boolean nonDirect = flightSearcher.hasDirectConnection(pzn, krk);

        //Then
        Assert.assertEquals(true, hasDirect);
        Assert.assertEquals(false, nonDirect);
    }

    @Test
    public void testGetDirectConnection(){
        //Given
        HashMap<Airport, Airport> expectedDirectMap = new HashMap<>();
        expectedDirectMap.put(pzn, wawa);

        //When
        HashMap<Airport, Airport> testMap = flightSearcher.getConnection(pzn, wawa);

        //Then
        Assert.assertEquals(expectedDirectMap, testMap);
    }

    @Test
    public void testGetNonDirectConnection(){
        //Given
        HashMap<Airport, Airport> expectedNonDirectMap = new HashMap<>();

        expectedNonDirectMap.put(pzn, wawa);
        expectedNonDirectMap.put(wawa, krk);

        //When
        HashMap<Airport, Airport> testMap1 = flightSearcher.getConnection(pzn, krk);
        System.out.println(testMap1);

        //Then
        Assert.assertEquals(expectedNonDirectMap, testMap1);
    }
}
