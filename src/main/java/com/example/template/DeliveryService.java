package com.example.template;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name ="delivery", url="${api.url.delivery}")
public interface DeliveryService {

    @RequestMapping(method = RequestMethod.POST, value = "/deliveries", consumes = "application/json")
    void startDelivery(Delivery delivery);

    @RequestMapping(method = RequestMethod.PATCH, value = "/deliveries/{deliveryId}", consumes = "application/json")
    void completeDelivery(@PathVariable("deliveryId") Long deliveryId, Delivery delivery);

    @RequestMapping(method = RequestMethod.PATCH, value = "/deliveries/{deliveryId}", consumes = "application/json")
    void cancelDelivery(@PathVariable("deliveryId") Long deliveryId,  Delivery delivery);
}
