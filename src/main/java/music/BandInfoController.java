package music;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
public class BandInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BandInfoController.class);

    private final BandInfoRepo repository;

    public BandInfoController(final BandInfoRepo repository) {this.repository = repository;}

    @RequestMapping(value="bands", method = RequestMethod.GET)
    public BandsInfoServiceResponse bands() {
        LOGGER.info("Request Received for [/bands]");
        final BandsInfoServiceResponse response = new BandsInfoServiceResponse();
        response.setType("success");
        final List<BandsInfo> bands = StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        response.setValue(bands);
        return response;
    }


        @RequestMapping(value="bands/{bandId}", method = RequestMethod.GET)
        public BandsInfoServiceResponse details(@PathVariable("bandId") final Long id) {
            LOGGER.info("Request Received for [/bands/{bandId}]");
        final BandsInfoServiceResponse response = new BandsInfoServiceResponse();
        response.setType("success");
        final List<BandsInfo> details = new ArrayList<>();
        repository.findById(id).ifPresent(details::add);
        response.setValue(details);
        return response;
    }

    public static class BandsInfoServiceResponse {
        private String type;
        private List<BandsInfo> value;
        public String getType() {return type;}
        public void setType(final String type){this.type = type;}

        public List<BandsInfo> getValue(){ return value;}
        public void setValue(final List<BandsInfo> value) { this.value = value;}
    }


}
