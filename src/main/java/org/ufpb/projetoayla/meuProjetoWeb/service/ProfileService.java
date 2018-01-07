package org.ufpb.projetoayla.meuProjetoWeb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ufpb.projetoayla.meuProjetoWeb.database.DatabaseClass;
import org.ufpb.projetoayla.meuProjetoWeb.exception.DataNotFoundException;
import org.ufpb.projetoayla.meuProjetoWeb.model.Profile;

public class ProfileService {

private Map<Long, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put(1L, new Profile(1L, "matheuspb@gmail.com"));
	}
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(long profileId){
		Profile profile = profiles.get(profileId);
		if(profile == null) {
			throw new DataNotFoundException("O profile de id " + profileId + " não foi encontrado!");
		}
		return profile;
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getId(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getUserEmail().isEmpty()){
			return null;
		}
		profiles.put(profile.getId(), profile);
		return profile;
	}
	
	public Profile removeProfile(long id){
		return profiles.remove(id);
	}
}
