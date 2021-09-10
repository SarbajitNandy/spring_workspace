package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.infy.dto.PlayerDTO;
import com.infy.entity.Player;
import com.infy.exception.InfyPlayerException;
import com.infy.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public List<PlayerDTO> getFirstSevenPlayers(int pageNo, int pageSize) throws InfyPlayerException {
		List<Player> listOfPlayer = playerRepository.
	}

	@Override
	public List<PlayerDTO> getAllPlayersByDebutDateAfter(String debutDate, int i, int j) throws InfyPlayerException {
		return null;
	}

	@Override
	public List<PlayerDTO> getAllPlayersSortedByRanking(Sort sort) throws InfyPlayerException {
		return null;
	}

	@Override
	public List<PlayerDTO> getAllPlayersOfCountrySortedByRanking(String country, Sort sort) throws InfyPlayerException {
		return null;
	}

}