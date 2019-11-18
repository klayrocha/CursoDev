package com.klayrocha.core.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.klayrocha.core.model.Task;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}
