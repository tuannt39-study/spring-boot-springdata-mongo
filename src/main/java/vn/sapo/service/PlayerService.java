package vn.sapo.service;

import vn.sapo.domain.Player;

import java.util.List;

public interface PlayerService {

    List<Player> findByName(String name);

    List<Player> findByNameLike(String name);

}
