package it.prova.springboot.batchwithprofiles.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({ "produzione" })
public @interface ProdProfile {
	
}
