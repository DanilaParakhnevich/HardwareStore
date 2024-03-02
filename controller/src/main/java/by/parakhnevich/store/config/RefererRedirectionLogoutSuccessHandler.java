package by.parakhnevich.store.config;

import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class RefererRedirectionLogoutSuccessHandler
        extends SimpleUrlLogoutSuccessHandler
        implements LogoutSuccessHandler {

    public RefererRedirectionLogoutSuccessHandler() {
        super();
        setUseReferer(true);
    }

}
