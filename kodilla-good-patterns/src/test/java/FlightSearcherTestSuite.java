import com.kodilla.good.patterns.challenges.flights.Airport;
import com.kodilla.good.patterns.challenges.flights.FlightSearcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class FlightSearcherTestSuite {

    @Test
    public void testGetNonDirectConnection(){
        //Given
        Airport pzn = new Airport("Poznań");
        Airport wawa = new Airport("Warszawa");
        Airport krk = new Airport("Kraków");
        Airport wrc = new Airport("Wrocław");

        HashMap<Airport, Airport> flights = new HashMap<>();

        flights.put(pzn, wawa);
        flights.put(pzn, wrc);
        flights.put(wawa, krk);
        flights.put(wawa, wrc);
        flights.put(wrc, wawa);
        flights.put(krk, wrc);

        FlightSearcher flightSearcher = new FlightSearcher(flights, pzn, krk);

        HashMap<Airport, Airport> expectedMap = new HashMap<>();

        expectedMap.put(pzn, wawa);
        expectedMap.put(wawa, krk);

        //When
        HashMap<Airport, Airport> testMap = flightSearcher.getNonDirectConnection(wawa);

        //Then
        Assert.assertEquals(expectedMap, testMap);
    }
}
