package com.infoservice.springjwt.security.services;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.infoservice.springjwt.models.Info;
import com.infoservice.springjwt.models.utils.PagingHeaders;
import com.infoservice.springjwt.models.utils.PagingResponse;
import com.infoservice.springjwt.repository.InfosRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InfoService {

	private final InfosRepository infosRepository;

	@Autowired
	public InfoService(InfosRepository infosRepository) {
//		super(Info.class);
		this.infosRepository = infosRepository;
	}

	/**
	 * delete info element by id
	 * 
	 * @param id
	 */
	public void delete(Long id) {
		Info infoEntity = infosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
				String.format("Can not find the entity Info (%s = %s).", "id", id.toString())));

		infosRepository.delete(infoEntity);
	}

	/**
	 * get Entity Info by id
	 * 
	 * @param id
	 * @return info element
	 */
	public Info get(Long id) {
		return infosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
				String.format("cannot find the entity Info (%s = %s).", "id", id.toString())));
	}

	public PagingResponse get(Specification<Info> spec, HttpHeaders headers, Sort sort) {
		if (isRequestPaged(headers)) {
			return get(spec, buildPageRequest(headers, sort));
		}else {
			List<Info> entitiesInfo = get(spec, sort);
			return new PagingResponse((long) entitiesInfo.size(), 0L, 0L, 0L, 0L, entitiesInfo);
			
		}
	}

	public boolean isRequestPaged(HttpHeaders headers) {

		return headers.containsKey(PagingHeaders.PAGE_NUMBER.getName())
				&& (headers.containsKey(PagingHeaders.PAGE_SIZE.getName()));
	}
	
	private Pageable buildPageRequest(HttpHeaders headers, Sort sort) {
        int page = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_NUMBER.getName())).get(0));
        int size = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_SIZE.getName())).get(0));
        return PageRequest.of(page, size, sort);
    }
	
	
	/**
     * get elements using Criteria.
     *
     * @param spec     *
     * @param pageable pagination data
     * @return retrieve elements with pagination
     */
    public PagingResponse get(Specification<Info> spec, Pageable pageable) {
        Page<Info> page = infosRepository.findAll(spec, pageable);
        List<Info> content = page.getContent();
        return new PagingResponse(page.getTotalElements(), (long) page.getNumber(), (long) page.getNumberOfElements(), pageable.getOffset(), (long) page.getTotalPages(), content);
    }
    
    
    /**
     * get elements using Criteria.
     *
     * @param spec *
     * @return elements
     */
    public List<Info> get(Specification<Info> spec, Sort sort) {
        return infosRepository.findAll(spec, sort);
    }
    
    
    /**
     * create element.
     *
     * @param item element to create
     * @return element after creation
     * //     * @throws CreateWithIdException   Exception lancée lors de la création d'un objet existant
     * @throws EntityNotFoundException Exception lors de récupération de l'entité en base
     */
    public Info create(Info item) {
        return infosRepository.save(item);
    }
    
    
    /**
     * save a list of info
     * @param infoList
     * @return
     */
    public Iterable<Info> saveAll(List<Info>infoList) {
    	if(infoList==null) {
    		throw new RuntimeException("Can not save Info, Info is empty.");
    	}
    	
    	return infosRepository.saveAll(infoList);
    	
    }
    
    
    public Info update(Long id, Info item) {
        if (item.getId() == null) {
            throw new RuntimeException("Can not update entity, entity without ID.");
        } else if (!id.equals(item.getId())) {
            throw new RuntimeException(String.format("Can not update entity, the resource ID (%d) not match the objet ID (%d).", id, item.getId()));
        }
        return infosRepository.save(item);
    }

}
