package it.prova.springboot.batchwithprofiles.annotation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({ "test" })
public @interface TestProfile {

	
}
