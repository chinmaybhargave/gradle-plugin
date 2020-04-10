package com.example.tasks;

import static org.junit.Assert.assertEquals;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;


public class SampleTask extends DefaultTask{
	
	@Input
	String argument;
	
	@TaskAction
	public void sampleTask() {
		Project project = this.getProject();
		project.getLogger().quiet("Inside sample task.");
		assertEquals(argument, "some-value");
	}

}
