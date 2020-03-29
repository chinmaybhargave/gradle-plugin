package com.example.plugins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class SampleTest {

	@Rule
	private TemporaryFolder testProjectDir = new TemporaryFolder();
	
	private BuildResult gradle(String ...arguments) {
		List<String> argumentsList = new ArrayList<>(5);
		argumentsList.addAll(Arrays.asList(arguments));
		argumentsList.add("--stacktrace");
	
		GradleRunner runner = GradleRunner.create()
				.withArguments(argumentsList)
				.withProjectDir(testProjectDir.getRoot())
				.withPluginClasspath()
				.withDebug(true);		

		return runner.build();
	}
	
	@Test 
	public void test_if_plugin_can_be_used() {
	
		BuildResult result = gradle("apply plugin: sample-plugin");
		System.out.println(result.getOutput());
	}
}