package com.wolf.hr.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;

import com.wolf.hr.service.PDManager;


@Service("pdManager")
public class PDManagerImpl implements PDManager{
	@Resource(name="processEngine")
	private ProcessEngine processEngine;

	public Collection<ProcessDefinition> getLasterVersions() {
		// TODO Auto-generated method stub
		List<ProcessDefinition> pdList = this.processEngine.getRepositoryService()
		.createProcessDefinitionQuery()
		.orderAsc(ProcessDefinitionQuery.PROPERTY_VERSION)
		.list();
		
		Map<String, ProcessDefinition> maps = new HashMap<String, ProcessDefinition>();
		for(ProcessDefinition pd:pdList){
			maps.put(pd.getKey(), pd);
		}
		return maps.values();
	}

	public void deploy(File resource) throws Exception{
		InputStream inputStream = new FileInputStream(resource);
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		this.processEngine.getRepositoryService()
		.createDeployment()
		.addResourcesFromZipInputStream(zipInputStream)
		.deploy();
	}

	public void deletePDKEY(String pdKEY) {
		// TODO Auto-generated method stub
		List<ProcessDefinition> pdList = this.processEngine.getRepositoryService()
		.createProcessDefinitionQuery()
		.processDefinitionKey(pdKEY)
		.list();
		for(ProcessDefinition pd:pdList){
			this.processEngine.getRepositoryService()
			.deleteDeploymentCascade(pd.getDeploymentId());
		}
	}

	public InputStream showImage(String deploymentId) {
		// TODO Auto-generated method stub
		ProcessDefinition pd = this.processEngine.getRepositoryService()
		.createProcessDefinitionQuery()
		.deploymentId(deploymentId)
		.uniqueResult();
		return this.processEngine.getRepositoryService()
		.getResourceAsStream(deploymentId, pd.getImageResourceName());
	}
	
}
