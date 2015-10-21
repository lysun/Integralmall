package com.doublev2v.integralmall.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConfigService {
	
	public static final String LIVE_ADDRES="live_address";
	public static final String BACKUP_LIVE_ADDRESS="backup_live_address";
	
	@Autowired
	private ConfigRepository repository;

	public void saveLiveAddress(String address, String backupAddress) {
		if(repository.exists(LIVE_ADDRES)) {
			repository.delete(LIVE_ADDRES);
		}
		if(repository.exists(BACKUP_LIVE_ADDRESS)) {
			repository.delete(BACKUP_LIVE_ADDRESS);
		}
		Config addressConfig=new Config(LIVE_ADDRES,address);
		Config backupAddressConfig=new Config(BACKUP_LIVE_ADDRESS,backupAddress);
		repository.save(addressConfig);
		repository.save(backupAddressConfig);
	}
	
	public Map<String, String> getLiveAddress() {
		Config addressConfig=repository.findOne(LIVE_ADDRES);
		Config backupAddressConfig=repository.findOne(BACKUP_LIVE_ADDRESS);
		Map<String, String> liveAddress=new HashMap<String, String>();
		liveAddress.put("liveAddress", addressConfig.getValue());
		liveAddress.put("backupAddress", backupAddressConfig.getValue());
		return liveAddress;
	}
	
}
