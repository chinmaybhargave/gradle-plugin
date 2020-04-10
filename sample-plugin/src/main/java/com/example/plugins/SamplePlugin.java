package com.example.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import com.example.tasks.SampleTask;

public class SamplePlugin implements Plugin<Project>{

	@Override
	public void apply(Project project) {
		project.getTasks().create("sampleTask", SampleTask.class);
	}

}
