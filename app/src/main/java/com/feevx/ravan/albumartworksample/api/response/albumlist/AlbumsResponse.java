package com.feevx.ravan.albumartworksample.api.response.albumlist;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class AlbumsResponse{

	@SerializedName("resultCount")
	private int resultCount;

	@SerializedName("results")
	private List<Album> results;

	public int getResultCount(){
		return resultCount;
	}

	public List<Album> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"AlbumsResponse{" + 
			"resultCount = '" + resultCount + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}