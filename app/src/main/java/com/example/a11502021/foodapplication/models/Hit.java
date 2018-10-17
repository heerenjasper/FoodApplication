package com.example.a11502021.foodapplication.models;

/**
 * Created by 11502021 on 10/10/2018.
 */

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
        "recipe",
        "bookmarked",
        "bought"
})
public class Hit {

    @JsonProperty("recipe")
    private Recipe recipe;
    @JsonProperty("bookmarked")
    private Boolean bookmarked;
    @JsonProperty("bought")
    private Boolean bought;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("recipe")
    public Recipe getRecipe() {
        return recipe;
    }

    @JsonProperty("recipe")
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @JsonProperty("bookmarked")
    public Boolean getBookmarked() {
        return bookmarked;
    }

    @JsonProperty("bookmarked")
    public void setBookmarked(Boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

    @JsonProperty("bought")
    public Boolean getBought() {
        return bought;
    }

    @JsonProperty("bought")
    public void setBought(Boolean bought) {
        this.bought = bought;
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
