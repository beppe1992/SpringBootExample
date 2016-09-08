package it.prova.springboot.batch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class BaseStepEsecutionListener implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		System.out.println("ESEGUENDO STEP " + stepExecution.getStepName());

	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("FINITO STEP " + stepExecution.getStepName());
		return null;
	}

}
