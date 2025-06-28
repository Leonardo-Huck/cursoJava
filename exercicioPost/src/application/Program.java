package application;

import Entities.Comment;
import Entities.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        //LocalDateTime time = LocalDateTime.now();

        Post p1 = new Post(
                LocalDateTime.now(), //LocalDateTime.parse("21/06/2018 13:05:44", formatter)
                "Traveling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);
        p1.addComment(new Comment("Have a nice trip!"));
        p1.addComment(new Comment("Wow that's awesome!"));

        Post p2 = new Post(
                LocalDateTime.parse("28/07/2018 23:14:19", formatter),
                "Good night guys",
                "See you Tomorrow",
                5);
        p2.addComment(new Comment("Good night"));
        p2.addComment(new Comment("May the Force be with you"));

        System.out.println(p1);
        System.out.println(p2);
    }
}
