package fi.tunnit.lila.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface MiscService {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public abstract void palveluAdmineille();

	@PreAuthorize("isAuthenticated()")
	public abstract void palveluSisaankirjautuneille();

	@PreAuthorize("permitAll")
	public abstract void palveluKaikille();

}