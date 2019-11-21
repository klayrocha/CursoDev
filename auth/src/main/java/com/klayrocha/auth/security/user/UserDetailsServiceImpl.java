package com.klayrocha.auth.security.user;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.klayrocha.core.model.ApplicationUser;
import com.klayrocha.core.repository.ApplicationUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final ApplicationUserRepository applicationUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		log.info(" Searching in the DB the user by username '{}'",username);
		ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
		log.info(" ApplicationUser found '{}'",applicationUser);
		
		if(applicationUser == null) {
			throw new UsernameNotFoundException("Application User Not found");
		}
		return new CustomUserDetails(applicationUser);
	}

	private static final class CustomUserDetails extends ApplicationUser implements UserDetails {
		
		CustomUserDetails(@NotNull ApplicationUser applicationUser) {
			super(applicationUser);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_" + this.getRole());
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}
		
	}
	
}
