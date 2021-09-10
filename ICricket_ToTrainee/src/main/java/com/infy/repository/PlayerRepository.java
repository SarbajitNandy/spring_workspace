package com.infy.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.infy.entity.Player;

public interface PlayerRepository extends PagingAndSortingRepository<Player, Integer> {
	List<Player> findFirst7();
	List<Player> findByDebutDateAfter(String date);
	List<Player> findByOrderByRanking(String country);
}