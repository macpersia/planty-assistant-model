package be.planty.models.assistant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionResponse {
    
    public final Integer statusCode;

    public ActionResponse(@JsonProperty("statusCode") Integer statusCode) {
        this.statusCode = statusCode;
    }
}
