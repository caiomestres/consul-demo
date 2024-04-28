package com.example.demo;

import com.example.demo.ErrorStuff.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class ConsulControllerImpl {

    @Value("${consul.url:http://localhost:8500}")
    private String consulUrl;

    @Autowired
    private ConsulConfig consulConfig;

    private final RestTemplate restTemplate;

    @Autowired
    public ConsulControllerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/")
    public Map<String, String> getConfigs() {
        return consulConfig.getAbacaxi();
    }

    @PutMapping("/")
    public String updateConfig(@RequestParam String key, @RequestParam String value) {
        String url = String.format("%s/v1/kv/%s", consulUrl, key);
        restTemplate.put(url, value);
        return "Updated";
    }

    @GetMapping("/exception")
    public Map<String, String> throwExceptionTest(@RequestParam int number) throws BusinessException {
        if (number < 5) {
            throw new BusinessException( "rnn0001", "Number must be at least 5.");
        }
        return consulConfig.getAbacaxi();
    }
}
