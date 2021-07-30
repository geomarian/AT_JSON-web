
package com.gipl.lms.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "test_id",
    "test_input"
})
public class MTest {

    @JsonProperty("test_id")
    private String testId;
    @JsonProperty("test_input")
    private MTestInput testInput;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("test_id")
    public String getTestId() {
        return testId;
    }

    @JsonProperty("test_id")
    public void setTestId(String testId) {
        this.testId = testId;
    }

    @JsonProperty("test_input")
    public MTestInput getTestInput() {
        return testInput;
    }

    @JsonProperty("test_input")
    public void setTestInput(MTestInput testInput) {
        this.testInput = testInput;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
