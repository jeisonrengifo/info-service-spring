package com.infoservice.springjwt.models.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PagingHeaders {
    PAGE_SIZE("Page-Size"),
    PAGE_NUMBER("Page-Number"),
    PAGE_OFFSET("Page-Offset"),
    PAGE_TOTAL("Page-Total"),
    COUNT("Count");


	private String name = null;
	
	private PagingHeaders(String name_) {
		this.name = name_;
	}
	
	public String getName() {
		return this.name;
	}
}
