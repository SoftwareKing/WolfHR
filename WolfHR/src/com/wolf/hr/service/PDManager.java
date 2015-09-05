package com.wolf.hr.service;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import org.jbpm.api.ProcessDefinition;

public interface PDManager {
	public Collection<ProcessDefinition> getLasterVersions();
	
	public void deploy(File resource) throws Exception;
	
	public void deletePDKEY(String pdKEY);
	
	public InputStream showImage(String deploymentId);
}
