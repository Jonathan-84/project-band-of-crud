package music;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner seedInfo(final BandInfoRepo bands){
        return args -> {
            bands.save(createDetails( 1L, "Oasis", "Link to band info", 7, "oasis_photo"));
            bands.save(createDetails( 2L, "Straylight Run", "Link to band info", 2, "SLR_photo"));
            bands.save(createDetails( 3L, "The Strumbellas", "Link to band info", 4, "strumbellas_photo"));

            for (final BandsInfo details: bands.findAll()) {
                LOGGER.info("Loaded: [{}]", details);
            }
        };
    }

    private BandsInfo createDetails (final Long id, final String name, final String backstory, final int numberStudioAlbums,
                                     final String bandPhoto) {

        final BandsInfo bandDetails = new BandsInfo();
        bandDetails.setId(id);
        bandDetails.setName(name);
        bandDetails.setBackstory(backstory);
        bandDetails.setNumberStudioAlbums(numberStudioAlbums);
        bandDetails.setBandPhoto(bandPhoto);
        return bandDetails;
    }

}
