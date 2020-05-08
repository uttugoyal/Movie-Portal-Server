package com.cg.omts.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.model.Show;

public interface ShowRepository {

	List<Show> findAllShow();

	List<Show> findShowByScreenId(Integer screenId);

	List<Show> findAllShowByTheaterdId(Integer theaterId);

	List<Show> findAllShowByTheaterdIdAndScreenId(Integer theaterId, Integer screenId);

	List<Show> findAllShowByMovieIdAndTheaterdIdAndTime(String movie1, Integer theaterId1, LocalDateTime time);

	List<Show> findAllShowByMovieIdAndTheaterdId(String movie1, Integer theaterId1);
}
