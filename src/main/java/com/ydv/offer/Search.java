package com.ydv.offer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Search {
    private Result[] results;
    private Query query;
    private Number limit;
    private String keyword;
    private Number offset;
    @JsonProperty
    private boolean sku;

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }


    public Number getLimit() {
        return limit;
    }

    public void setLimit(Number limit) {
        this.limit = limit;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public boolean getsku() {
        return sku;
    }

    public void setSku(boolean sku) {
        this.sku = sku;
    }

    public Number getOffset() {
        return offset;
    }

    public void setOffset(Number offset) {
        this.offset = offset;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
