package com.mercury.TeamMercuryCradlePlatform;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;

@SpringBootApplication
public class TeamMercuryCradlePlatformApplication {
	public static void main(String[] args) {
		SpringApplication.run(TeamMercuryCradlePlatformApplication.class, args);
	}

	private Connector httpsRedirect() {
		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		return connector;
	}

	@Bean
	public ServletWebServerFactory servletWebServerFactory() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory(){
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint securityConstraint = new SecurityConstraint();
				securityConstraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection securityCollection = new SecurityCollection();
				securityCollection.addPattern("/*");
				securityConstraint.addCollection(securityCollection);
				context.addConstraint(securityConstraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(httpsRedirect());
		return tomcat;
	}
}
