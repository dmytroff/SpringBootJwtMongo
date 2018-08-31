package rc;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... strings) throws  Exception{
        Hotel marriot =new Hotel(
                "Marriot",
                130,
                new Address( "NewYork", "USA"),
                Arrays.asList(
                        new  Review("John",8, false),
                        new  Review("Mary",5, true)
                )
        );
        Hotel iberostar =new Hotel(
                "Iberostar",
                80,
                new Address( "Nigril", "Janaica"),
                Arrays.asList(
                        new  Review("Mike",8, false),
                        new  Review("Julia",5, true)
                )
        );
        Hotel grandBahia =new Hotel(
                "Grand Bahia",
                90,
                new Address( "Cancun", "Mexico"),
                Arrays.asList(
                        new  Review("Robert",8, false),
                        new  Review("Nancy",4, true)
                )
        );
        Hotel lordBaltimore =new Hotel(
                "Lord Baltimore",
                200,
                new Address( "Baltimore", "USA"),
                Arrays.asList(
                        new  Review("Angela",5, false),
                        new  Review("Marcy",3, true)
                )
        );
        //drop all hotels
        this.hotelRepository.deleteAll();
        // add our hotels to the DB

        List<Hotel> hotels =Arrays.asList(marriot,iberostar,grandBahia,lordBaltimore);
        this.hotelRepository.save(hotels);
    }
}
