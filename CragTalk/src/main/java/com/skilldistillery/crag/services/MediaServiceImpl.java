package com.skilldistillery.crag.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.crag.entities.Media;
import com.skilldistillery.crag.entities.User;
import com.skilldistillery.crag.repositories.MediaRepository;
import com.skilldistillery.crag.repositories.UserRepository;

@Service
public class MediaServiceImpl implements MediaService {

	@Autowired
	private MediaRepository mediaRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Media> index(String username) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		User mediaUser = userRepo.findByUsername(username);
		return mediaUser.getMediaList();
	}

	@Override
	public Media show(String username, int mediaId) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		Optional<Media> mediaOpt = mediaRepo.findById(mediaId);
		Media media = null;
		if (mediaOpt.isPresent()) {
			media = mediaOpt.get();
		}
		return media;
	}

	@Override
	public Media create(String username, Media media) {
		User user = userRepo.findByUsername(username);
		if (user != null) {
			mediaRepo.saveAndFlush(media);
		}
		return media;
	}

	@Override
	public Media update(String username, int mediaId, Media media) {
		if (userRepo.findByUsername(username) == null) {
			return null;
		}
		Optional<Media> mediaOpt = mediaRepo.findById(mediaId);
		Media managedMedia = null;
		if (mediaOpt.isPresent()) {
			managedMedia = mediaOpt.get();
			managedMedia.setMediaUrl(media.getMediaUrl());
		}
		mediaRepo.saveAndFlush(managedMedia);
		return managedMedia;
	}

	@Override
	public boolean destroy(String username, int mediaId) {
		boolean deleted = false;
		if (userRepo.findByUsername(username) == null || mediaRepo.findById(mediaId) == null) {
			return deleted;
		}
		Optional<Media> mediaOpt = mediaRepo.findById(mediaId);
		Media media = null;
		if (mediaOpt.isPresent()) {
			media = mediaOpt.get();
			mediaRepo.delete(media);
			deleted = true;
		}
		return deleted;
	}
}
