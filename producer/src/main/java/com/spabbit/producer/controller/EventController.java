package com.spabbit.producer.controller;

import com.spabbit.common.event.model.Company;
import com.spabbit.producer.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
	
    private static final Logger LOG = LoggerFactory.getLogger(EventController.class);

    @Autowired
    Producer producer;

    @RequestMapping(value = "/events", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Company company) {
        LOG.debug(Company.class.getSimpleName() + " request received");

        /*
         * send message to RabbitMQ
         */
        producer.produce(company);

    }
        
}
