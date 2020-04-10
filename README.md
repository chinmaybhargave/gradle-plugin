# gradle-plugin-java-implementation

- 'sample-plugin' project consists of Gradle Plugin Implementation in Java

Contents <br/>
1. Gradle Task and Plugin implementation
2. Test the plugin and task in gradle script

Important files <br/>
1. example-plugin.properties : This properties file configure the Java Plugin Class to the plugin name. This file should be present at src/main/resources/META-INF/gradle-plugins/

Issues faced <br/>
1. For some reasone, in test-gradle.gradle file [ apply plugin: 'example-plugin' ] didn't work but
[ plugins {	id 'example-plugin' } ] worked. 
