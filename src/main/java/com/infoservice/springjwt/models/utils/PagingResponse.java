package com.infoservice.springjwt.models.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.infoservice.springjwt.models.Info;

/**
 * DTO using for pagination
 */
@Getter
@Setter
@AllArgsConstructor
public class PagingResponse {

    public PagingResponse(long size, long pageNumber, long pageSize, long pageOffset, long pageTotal, List<Info> elements) {
		// TODO Auto-generated constructor stub
    	this.count = size;
    	this.pageNumber = pageNumber;
    	this.pageSize = pageSize;
    	this.pageOffset = pageOffset;
    	this.pageTotal = pageTotal;
    	this.elements = elements;
    	
	}
	/**
     * entity count
     */
    private Long count;
    /**
     * page number, 0 indicate the first page.
     */
    private Long pageNumber;
    /**
     * size of page, 0 indicate infinite-sized.
     */
    private Long pageSize;
    /**
     * Offset from the of pagination.
     */
    private Long pageOffset;
    /**
     * the number total of pages.
     */
    private Long pageTotal;
    /**
     * elements of page.
     */
    private List<Info> elements;
}
