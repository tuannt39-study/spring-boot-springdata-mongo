package vn.sapo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import vn.sapo.domain.Player;
import vn.sapo.repository.PlayerRepository;

import java.util.List;

@SpringBootApplication
public class SpringBootSpringdataMongoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootSpringdataMongoApplication.class, args);

        ApplicationContext applicationContext = SpringApplication.run(SpringBootSpringdataMongoApplication.class, args);
        PlayerRepository playerRepository = applicationContext.getBean(PlayerRepository.class);

        System.out.println("--Insert--");
        Player player1 = new Player();
        player1.setName("Messi");
        player1.setAge(20);
        player1.setFootballClub("Barcelona");
        player1.setPosition("Striker");
        playerRepository.save(player1);
        Player player2 = new Player();
        player2.setId("1");
        player2.setName("Ramos");
        player2.setAge(20);
        player2.setFootballClub("Real Madrid");
        player2.setPosition("Midfielder");
        playerRepository.save(player2);
        System.out.println("--Insert Success--");

        System.out.println("--Find Player Where name = 'Messi'--");
        List<Player> list1 = playerRepository.findByName("Messi");
        for(Player player: list1) {
            System.out.println(player);
        }

        System.out.println("--Find Player Where name contains 'Ra'--");
        List<Player> list2 = playerRepository.findByNameLike("Ra");
        for(Player player: list2) {
            System.out.println(player);
        }

        System.out.println("--Update Player--");
        String id = "1";
        Player player = playerRepository.findById(id).orElse(null);
        if (player == null) {
            System.out.println("Not found player with id = " + id);
        } else {
            System.out.println(player);
            player.setName("Marcelo");
            playerRepository.save(player);
            System.out.println("--Updated--");
        }

        System.out.println("--Delete Player--");
        String idD = "1";
        Player playerD = playerRepository.findById(idD).orElse(null);
        if (playerD == null) {
            System.out.println("Not found player with id = " + idD);
        } else {
            System.out.println(playerD);
            playerRepository.delete(playerD);
            System.out.println("--Deleted--");
        }

        System.out.println("--Find All--");
        List<Player> allPlayers = playerRepository.findAll();
        for(Player playerA: allPlayers) {
            System.out.println(playerA);
        }

    }

}
