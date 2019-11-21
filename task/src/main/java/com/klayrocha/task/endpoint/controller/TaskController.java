package com.klayrocha.task.endpoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klayrocha.core.model.Task;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("v1/admin/task")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Endpoints to manage task")
public class TaskController {
	
	private final TaskService taskService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "List all available task", response = Task[].class)
	public ResponseEntity<Iterable<Task>> list(Pageable pageable) {
		log.info("Controller Listing all tasks");
		return new ResponseEntity<>(taskService.list(pageable), HttpStatus.OK);
	}

}
