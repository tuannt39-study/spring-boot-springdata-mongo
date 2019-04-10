package vn.sapo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import vn.sapo.domain.Player;

import java.util.List;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    @Query("{ 'name': ?0}")
    List<Player> findByName(String name);

    List<Player> findByNameLike(String name);

}
