import com.napier.sem.App;
import com.napier.sem.City;
import com.napier.sem.Country;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class test {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void printTopCapitalCityRegionPopulationsEmpty()
    {
        // Create Array
        ArrayList<City> cities = new ArrayList<City>();
        //Pass Empty Array
        app.printTopCapitalCityRegionPopulations(cities);
    }
}
