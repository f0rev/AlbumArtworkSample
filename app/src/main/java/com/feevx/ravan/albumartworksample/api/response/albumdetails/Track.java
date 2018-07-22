package com.feevx.ravan.albumartworksample.api.response.albumdetails;

import javax.annotation.Generated;

import com.feevx.ravan.albumartworksample.utils.DateConverter;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Track {

	@SerializedName("artworkUrl100")
	private String artworkUrl100;

	@SerializedName("trackTimeMillis")
	private int trackTimeMillis;

	@SerializedName("country")
	private String country;

	@SerializedName("previewUrl")
	private String previewUrl;

	@SerializedName("artistId")
	private int artistId;

	@SerializedName("trackName")
	private String trackName;

	@SerializedName("collectionName")
	private String collectionName;

	@SerializedName("artistViewUrl")
	private String artistViewUrl;

	@SerializedName("discNumber")
	private int discNumber;

	@SerializedName("trackCount")
	private int trackCount;

	@SerializedName("artworkUrl30")
	private String artworkUrl30;

	@SerializedName("wrapperType")
	private String wrapperType;

	@SerializedName("currency")
	private String currency;

	@SerializedName("collectionId")
	private int collectionId;

	@SerializedName("trackExplicitness")
	private String trackExplicitness;

	@SerializedName("collectionViewUrl")
	private String collectionViewUrl;

	@SerializedName("contentAdvisoryRating")
	private String contentAdvisoryRating;

	@SerializedName("trackNumber")
	private int trackNumber;

	@SerializedName("releaseDate")
	private String releaseDate;

	@SerializedName("kind")
	private String kind;

	@SerializedName("trackId")
	private int trackId;

	@SerializedName("collectionPrice")
	private double collectionPrice;

	@SerializedName("discCount")
	private int discCount;

	@SerializedName("primaryGenreName")
	private String primaryGenreName;

	@SerializedName("trackPrice")
	private double trackPrice;

	@SerializedName("collectionExplicitness")
	private String collectionExplicitness;

	@SerializedName("trackViewUrl")
	private String trackViewUrl;

	@SerializedName("artworkUrl60")
	private String artworkUrl60;

	@SerializedName("trackCensoredName")
	private String trackCensoredName;

	@SerializedName("artistName")
	private String artistName;

	@SerializedName("collectionCensoredName")
	private String collectionCensoredName;

	@SerializedName("isStreamable")
	private boolean isStreamable;

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("amgArtistId")
	private int amgArtistId;

	@SerializedName("collectionType")
	private String collectionType;

	public String getArtworkUrl100(){
		return artworkUrl100;
	}

	public String getTrackTimeMillis(){
		return DateConverter.getCorrectTrackLength(String.valueOf(trackTimeMillis));
	}

	public String getCountry(){
		return country;
	}

	public String getPreviewUrl(){
		return previewUrl;
	}

	public int getArtistId(){
		return artistId;
	}

	public String getTrackName(){
		return trackName;
	}

	public String getCollectionName(){
		return collectionName;
	}

	public String getArtistViewUrl(){
		return artistViewUrl;
	}

	public int getDiscNumber(){
		return discNumber;
	}

	public int getTrackCount(){
		return trackCount;
	}

	public String getArtworkUrl30(){
		return artworkUrl30;
	}

	public String getWrapperType(){
		return wrapperType;
	}

	public String getCurrency(){
		return currency;
	}

	public int getCollectionId(){
		return collectionId;
	}

	public String getTrackExplicitness(){
		return trackExplicitness;
	}

	public String getCollectionViewUrl(){
		return collectionViewUrl;
	}

	public String getContentAdvisoryRating(){
		return contentAdvisoryRating;
	}

	public String getTrackNumber(){
		return String.valueOf(trackNumber) + ".";
	}

	public String getReleaseDate(){
		return DateConverter.getUiDate(releaseDate);
	}

	public String getKind(){
		return kind;
	}

	public int getTrackId(){
		return trackId;
	}

	public String getCollectionPrice(){
		return String.valueOf(collectionPrice) + "$";
	}

	public int getDiscCount(){
		return discCount;
	}

	public String getPrimaryGenreName(){
		return primaryGenreName;
	}

	public String getTrackPrice(){
		return String.valueOf(trackPrice) + "$";
	}

	public String getCollectionExplicitness(){
		return collectionExplicitness;
	}

	public String getTrackViewUrl(){
		return trackViewUrl;
	}

	public String getArtworkUrl60(){
		return artworkUrl60;
	}

	public String getTrackCensoredName(){
		return trackCensoredName;
	}

	public String getArtistName(){
		return artistName;
	}

	public String getCollectionCensoredName(){
		return collectionCensoredName;
	}

	public boolean isIsStreamable(){
		return isStreamable;
	}

	public String getCopyright(){
		return copyright;
	}

	public int getAmgArtistId(){
		return amgArtistId;
	}

	public String getCollectionType(){
		return collectionType;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"artworkUrl100 = '" + artworkUrl100 + '\'' + 
			",trackTimeMillis = '" + trackTimeMillis + '\'' + 
			",country = '" + country + '\'' + 
			",previewUrl = '" + previewUrl + '\'' + 
			",artistId = '" + artistId + '\'' + 
			",trackName = '" + trackName + '\'' + 
			",collectionName = '" + collectionName + '\'' + 
			",artistViewUrl = '" + artistViewUrl + '\'' + 
			",discNumber = '" + discNumber + '\'' + 
			",trackCount = '" + trackCount + '\'' + 
			",artworkUrl30 = '" + artworkUrl30 + '\'' + 
			",wrapperType = '" + wrapperType + '\'' + 
			",currency = '" + currency + '\'' + 
			",collectionId = '" + collectionId + '\'' + 
			",trackExplicitness = '" + trackExplicitness + '\'' + 
			",collectionViewUrl = '" + collectionViewUrl + '\'' + 
			",contentAdvisoryRating = '" + contentAdvisoryRating + '\'' + 
			",trackNumber = '" + trackNumber + '\'' + 
			",releaseDate = '" + releaseDate + '\'' + 
			",kind = '" + kind + '\'' + 
			",trackId = '" + trackId + '\'' + 
			",collectionPrice = '" + collectionPrice + '\'' + 
			",discCount = '" + discCount + '\'' + 
			",primaryGenreName = '" + primaryGenreName + '\'' + 
			",trackPrice = '" + trackPrice + '\'' + 
			",collectionExplicitness = '" + collectionExplicitness + '\'' + 
			",trackViewUrl = '" + trackViewUrl + '\'' + 
			",artworkUrl60 = '" + artworkUrl60 + '\'' + 
			",trackCensoredName = '" + trackCensoredName + '\'' + 
			",artistName = '" + artistName + '\'' + 
			",collectionCensoredName = '" + collectionCensoredName + '\'' + 
			",isStreamable = '" + isStreamable + '\'' + 
			",copyright = '" + copyright + '\'' + 
			",amgArtistId = '" + amgArtistId + '\'' + 
			",collectionType = '" + collectionType + '\'' + 
			"}";
		}
}