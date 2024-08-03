package com.application.banking_system_monolithic.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Utility {
    public static final String notificationTopic = "NotificationTopic";
    public static final String notificationConsumerGrpId = "NotificationConsumerGrpId";

    public static Object getObjectFromJson(String json, Class className) {
        Gson gson = new Gson();
        try {
            Object object = gson.fromJson(json, className);
            return object;
        } catch (JsonSyntaxException e) {
            log.error(e.getMessage());
            return new Object();
        }
    }

    public static String getJsonString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
