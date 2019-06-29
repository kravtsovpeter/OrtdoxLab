package com.ortdox.dev.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ortdox.dev.domain.Meeting;

/**
 * DAO-репозиторий для встреч
 * @author pkravtsov
 */
public interface MeetingRepo extends CrudRepository<Meeting, Long> {
	
	/** Поиск по полю place */
	List<Meeting> findByPlace(String place);
}
