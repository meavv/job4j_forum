package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class PostService {

    private final HashMap<Integer, Post> posts = new HashMap();
    int count = 1;

    public PostService() {
        add(Post.of("Продаю машину ладу 01.", "Продажа срочно 1", 1));
        add(Post.of("Продаю машину ладу 02.","Продажа срочно 2", 2));
        add(Post.of("Продаю машину ладу 03.", "Продажа срочно 3", 3));
    }

    public Post add(Post post){
        return posts.containsKey(post.getId()) ?
                posts.replace(post.getId(), post) : posts.put(count++, post);
    }

    public List<Post> getAll() {
        return new ArrayList(posts.values());
    }

    public Post getId(int id){
        return posts.get(id);
    }

    public int getCount() {
        return count;
    }
}