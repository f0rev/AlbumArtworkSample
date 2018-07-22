package com.feevx.ravan.albumartworksample.api.response.albumdetails;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class AlbumDetailsResponse{

	@SerializedName("resultCount")
	private int resultCount;

	@SerializedName("results")
	private List<Track> results;

	public int getResultCount(){
		return resultCount;
	}

	public List<Track> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"AlbumDetailsResponse{" + 
			"resultCount = '" + resultCount + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}