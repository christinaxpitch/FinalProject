package com.skilldistillery.crag.services;

import java.util.List;

import com.skilldistillery.crag.entities.Media;

public interface MediaService {
    public List<Media> index(String username);

    public Media show(String username, int mediaId);

    public Media create(String username, Media media);

    public Media update(String username, int mediaId, Media meida);

    public boolean destroy(String username, int mediaId);

}
