package vn.sapo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import vn.sapo.domain.Player;
import vn.sapo.repository.PlayerRepository;
import vn.sapo.service.PlayerService;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {


    private final Logger log = LoggerFactory.getLogger(PlayerServiceImpl.class);

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findByName(String name) {
        log.debug("findByName : {}", name);
        return playerRepository.findByName(name);
    }

    @Override
    public List<Player> findByNameLike(String name) {
        log.debug("findByNameLike : {}", name);
        return playerRepository.findByNameLike(name);
    }

}
