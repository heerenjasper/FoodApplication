package com.example.a11502021.foodapplication.models;

/**
 * Created by 11502021 on 10/10/2018.
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sane",
        "q",
        "app_key",
        "app_id"
})
public class Params {

    @JsonProperty("sane")
    private List<Object> sane = null;
    @JsonProperty("q")
    private List<String> q = null;
    @JsonProperty("app_key")
    private List<String> appKey = null;
    @JsonProperty("app_id")
    private List<String> appId = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sane")
    public List<Object> getSane() {
        return sane;
    }

    @JsonProperty("sane")
    public void setSane(List<Object> sane) {
        this.sane = sane;
    }

    @JsonProperty("q")
    public List<String> getQ() {
        return q;
    }

    @JsonProperty("q")
    public void setQ(List<String> q) {
        this.q = q;
    }

    @JsonProperty("app_key")
    public List<String> getAppKey() {
        return appKey;
    }

    @JsonProperty("app_key")
    public void setAppKey(List<String> appKey) {
        this.appKey = appKey;
    }

    @JsonProperty("app_id")
    public List<String> getAppId() {
        return appId;
    }

    @JsonProperty("app_id")
    public void setAppId(List<String> appId) {
        this.appId = appId;
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
