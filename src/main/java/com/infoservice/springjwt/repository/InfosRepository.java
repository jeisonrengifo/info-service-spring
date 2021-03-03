package com.infoservice.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.infoservice.springjwt.models.Info;
import com.infoservice.springjwt.models.TypeInfo;
import com.infoservice.springjwt.models.User;

@Repository
public interface InfosRepository extends PagingAndSortingRepository<Info, Long>,JpaSpecificationExecutor<Info> {
	List<Info> findByUser(User user);

	List<Info> findByTypeInfo(TypeInfo typeInfo);
}
