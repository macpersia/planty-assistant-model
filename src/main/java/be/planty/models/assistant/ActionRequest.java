package be.planty.models.assistant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionRequest {

    public final String action;

    @JsonCreator
    public ActionRequest(@JsonProperty("action") String action) {
        this.action = action;
    }
}
