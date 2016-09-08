package it.prova.springboot.batch.reader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.util.CollectionUtils;

public class BaseReader implements ItemReader<String> {

	List<String> stringhe = CollectionUtils.arrayToList(new String[] {
			"Stringa1", "Stringa2", "Stringa3" });

	int contatore = -1;

	@Override
	public String read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {

		if (contatore < stringhe.size() - 1) {
			contatore++;
			return stringhe.get(contatore);
		} else {
			return null;
		}

	}

}
