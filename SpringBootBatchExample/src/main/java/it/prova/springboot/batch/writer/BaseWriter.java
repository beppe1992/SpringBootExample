package it.prova.springboot.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class BaseWriter<String> implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> listaStringhe) throws Exception {
		for (String stringa : listaStringhe) {
			System.out.println(stringa);
		}

	}

}
