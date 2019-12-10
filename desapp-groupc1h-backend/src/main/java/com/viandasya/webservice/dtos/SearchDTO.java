package com.viandasya.webservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class SearchDTO {
    private int pageCurrent;
    private int pageSize;
    private String filterField;
    private String filterQuery;
    private String order;
    @JsonIgnore
    private Map<String, BiFunction<Integer, Integer, PageRequest>> pageRequestsFunction;

    public SearchDTO(int pageCurrent, String filterField, String filterQuery, String order) {
        this.pageCurrent = pageCurrent;
        this.filterField = filterField;
        this.filterQuery = filterQuery;
        this.order = order;
        this.setPageRequestsFunction();
    }

    private void addPageRequestFunction(String key, Sort.Direction direction, String sortField) {
        this.pageRequestsFunction.put(key, (current, size) ->
                PageRequest.of(current, size, Sort.by(direction, sortField)));
    }

    private void setPageRequestsFunction() {
        this.pageRequestsFunction = new HashMap<>();
        this.addPageRequestFunction("lowestPrice", Sort.Direction.ASC, "priceHandler.current.price");
        this.addPageRequestFunction("highestPrice", Sort.Direction.DESC, "priceHandler.current.price");
        this.addPageRequestFunction("lowestScore", Sort.Direction.ASC, "score");
        this.addPageRequestFunction("highestScore", Sort.Direction.DESC, "score");
        pageRequestsFunction.put(null, PageRequest::of);
    }

    public int getPageCurrent() {
        return pageCurrent - 1;
    }

    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getFilterField() {
        return filterField;
    }

    public void setFilterField(String filterField) {
        this.filterField = filterField;
    }

    public String getFilterQuery() {
        return filterQuery;
    }

    public void setFilterQuery(String filterQuery) {
        this.filterQuery = filterQuery;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public PageRequest getPageRequest() {
        return this.pageRequestsFunction.get(this.order)
                .apply(this.getPageCurrent(), pageSize);
    }

}
