package com.klayrocha.core.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.klayrocha.core.model.ApplicationUser;

@Repository
public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long> {

	ApplicationUser findByUsername(String username);
}
