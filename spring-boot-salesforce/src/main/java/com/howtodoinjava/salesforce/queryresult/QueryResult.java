package com.howtodoinjava.salesforce.queryresult;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryResult<T> {
	public List<T> records;
}