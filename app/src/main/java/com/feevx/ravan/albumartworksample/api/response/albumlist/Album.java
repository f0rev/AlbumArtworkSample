package com.feevx.ravan.albumartworksample.api.response.albumlist;

import javax.annotation.Generated;

import com.feevx.ravan.albumartworksample.utils.DateConverter;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Generated("com.robohorse.robopojogenerator")
public class Album {

	@SerializedName("artworkUrl100")
	private String artworkUrl100;

	@SerializedName("country")
	private String country;

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("collectionViewUrl")
	private String collectionViewUrl;

	@SerializedName("amgArtistId")
	private int amgArtistId;

	@SerializedName("releaseDate")
	private String releaseDate;

	@SerializedName("artistId")
	private int artistId;

	@SerializedName("collectionPrice")
	private double collectionPrice;

	@SerializedName("primaryGenreName")
	private String primaryGenreName;

	@SerializedName("collectionName")
	private String collectionName;

	@SerializedName("artistViewUrl")
	private String artistViewUrl;

	@SerializedName("collectionType")
	private String collectionType;

	@SerializedName("collectionExplicitness")
	private String collectionExplicitness;

	@SerializedName("trackCount")
	private int trackCount;

	@SerializedName("artworkUrl60")
	private String artworkUrl60;

	@SerializedName("wrapperType")
	private String wrapperType;

	@SerializedName("artistName")
	private String artistName;

	@SerializedName("currency")
	private String currency;

	@SerializedName("collectionId")
	private int collectionId;

	@SerializedName("collectionCensoredName")
	private String collectionCensoredName;

	@SerializedName("contentAdvisoryRating")
	private String contentAdvisoryRating;

	public String getArtworkUrl100(){
		return artworkUrl100;
	}

	public String getCountry(){
		return country;
	}

	public String getCopyright(){
		return copyright;
	}

	public String getCollectionViewUrl(){
		return collectionViewUrl;
	}

	public int getAmgArtistId(){
		return amgArtistId;
	}

	public String getReleaseDate(){
		return 	DateConverter.getUiDate(releaseDate);
	}

	public int getArtistId(){
		return artistId;
	}

	public double getCollectionPrice(){
		return collectionPrice;
	}

	public String getPrimaryGenreName(){
		return primaryGenreName;
	}

	public String getCollectionName(){
		return collectionName;
	}

	public String getArtistViewUrl(){
		return artistViewUrl;
	}

	public String getCollectionType(){
		return collectionType;
	}

	public String getCollectionExplicitness(){
		return collectionExplicitness;
	}

	public int getTrackCount(){
		return trackCount;
	}

	public String getArtworkUrl60(){
		return artworkUrl60;
	}

	public String getWrapperType(){
		return wrapperType;
	}

	public String getArtistName(){
		return artistName;
	}

	public String getCurrency(){
		return currency;
	}

	public int getCollectionId(){
		return collectionId;
	}

	public String getCollectionCensoredName(){
		return collectionCensoredName;
	}

	public String getContentAdvisoryRating(){
		return contentAdvisoryRating;
	}

	@Override
 	public String toString(){
		return 
			"Track{" +
			"artworkUrl100 = '" + artworkUrl100 + '\'' + 
			",country = '" + country + '\'' + 
			",copyright = '" + copyright + '\'' + 
			",collectionViewUrl = '" + collectionViewUrl + '\'' + 
			",amgArtistId = '" + amgArtistId + '\'' + 
			",releaseDate = '" + releaseDate + '\'' + 
			",artistId = '" + artistId + '\'' + 
			",collectionPrice = '" + collectionPrice + '\'' + 
			",primaryGenreName = '" + primaryGenreName + '\'' + 
			",collectionName = '" + collectionName + '\'' + 
			",artistViewUrl = '" + artistViewUrl + '\'' + 
			",collectionType = '" + collectionType + '\'' + 
			",collectionExplicitness = '" + collectionExplicitness + '\'' + 
			",trackCount = '" + trackCount + '\'' + 
			",artworkUrl60 = '" + artworkUrl60 + '\'' + 
			",wrapperType = '" + wrapperType + '\'' + 
			",artistName = '" + artistName + '\'' + 
			",currency = '" + currency + '\'' + 
			",collectionId = '" + collectionId + '\'' + 
			",collectionCensoredName = '" + collectionCensoredName + '\'' + 
			",contentAdvisoryRating = '" + contentAdvisoryRating + '\'' + 
			"}";
		}
}