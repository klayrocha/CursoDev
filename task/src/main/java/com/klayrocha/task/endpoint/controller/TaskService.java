package com.klayrocha.task.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.klayrocha.core.model.Task;
import com.klayrocha.core.repository.TaskRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskService {

	private final TaskRepository taskRepository;
	
	public Iterable<Task> list(Pageable pageable) {
		log.info("Service Listing all tasks");
		return taskRepository.findAll(pageable);
	}
}
