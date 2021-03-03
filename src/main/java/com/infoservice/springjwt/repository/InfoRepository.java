package com.infoservice.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infoservice.springjwt.models.Info;
import com.infoservice.springjwt.models.TypeInfo;
import com.infoservice.springjwt.models.User;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {

	List<Info> findByUser(User user);

	List<Info> findByTypeInfo(TypeInfo typeInfo);
}
