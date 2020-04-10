package com.example.plugins;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.gradle.internal.impldep.org.testng.Assert;
import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.gradle.testkit.runner.TaskOutcome;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class SamplePluginTest {

	@Rule
	public TemporaryFolder testProjectDir = new TemporaryFolder();
	
	private File testBuildGradle;
	
		
	@Before
	public void setup() throws IOException {
		testBuildGradle = new File(this.getClass().getResource("/test-build.gradle").getFile());
		FileUtils.copyFileToDirectory(testBuildGradle, testProjectDir.getRoot());
		FileUtils.moveFile(new File(testProjectDir.getRoot()+"/test-build.gradle"), new File(testProjectDir.getRoot()+"/build.gradle"));
	}
	
	@Test 
	//@Ignore
	public void test_if_plugin_can_be_used() {
	
		BuildResult result = gradle("sampleTask");
		Assert.assertEquals(TaskOutcome.SUCCESS, result.task(":sampleTask").getOutcome());
	}
	
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

}