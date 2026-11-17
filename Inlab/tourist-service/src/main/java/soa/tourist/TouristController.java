package soa.tourist;

import java.util.Map;
import java.util.UUID;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TouristController {

    private final String instanceId = UUID.randomUUID().toString();
    private final TouristRepository touristRepository;

    public TouristController(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @GetMapping("/tourists")
    public Map<String, String> tourists() {
        return Map.of("service", "TOURIST-SERVICE", "instance", instanceId);
    }

    @PostMapping("/tourists")
    @ResponseStatus(HttpStatus.CREATED)
    public Tourist createTourist(@RequestBody Tourist tourist) {
        return touristRepository.save(tourist);
    }

    @GetMapping("/tourists/data")
    public List<Tourist> getTourists() {
        return touristRepository.findAll();
    }
}
