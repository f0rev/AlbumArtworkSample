package com.feevx.ravan.albumartworksample.api;

import com.feevx.ravan.albumartworksample.api.response.albumdetails.AlbumDetailsResponse;
import com.feevx.ravan.albumartworksample.api.response.albumlist.AlbumsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItunesWebservice {

    @GET("/search?media=music&entity=album&")
    Observable<AlbumsResponse> getAlbums(@Query("term") String term);

    @GET("/lookup?entity=song&")
    Observable<AlbumDetailsResponse> getAlbums(@Query("id") int id);

}
