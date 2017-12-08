package com.example.spring.jdbc.service;

import com.example.spring.jdbc.dao.PeopleJpaDao;
import com.example.spring.jdbc.model.People;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Service
public class PeopleJpaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PeopleJpaService.class);

	@Resource
	private PeopleJpaDao peopleJpaDao;

	public List<People> findAll() {
		return peopleJpaDao.findAll();
	}

	// PROPAGATION_REQUIRED,ISOLATION_DEFAULT
	@Transactional
	@CachePut("peopleJpa")
	@CacheEvict(value = { "peopleJpa"}, allEntries = true)
	public void save(People people) {
		peopleJpaDao.save(people);
	}

	@Cacheable("peopleJpa")
	public Collection<People> findByFullName(String fullName) {
		LOGGER.info("find from database for : {}", fullName);
		Collection<People> all = peopleJpaDao.findByFullName(fullName);
		return all;
	}

}
