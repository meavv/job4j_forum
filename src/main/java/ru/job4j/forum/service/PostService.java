package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {

    private final HashMap<Integer, Post> posts = new HashMap();

    private final AtomicInteger count = new AtomicInteger(1);

    public PostService() {
        add(Post.of("Продаю машину ладу 01.", "Продажа срочно 1", 1));
        add(Post.of("Продаю машину ладу 02.", "Продажа срочно 2", 2));
        add(Post.of("Продаю машину ладу 03.", "Продажа срочно 3", 3));
    }

    public Post add(Post post) {
        post.setId(count.get());
        count.addAndGet(1);
        return posts.put(post.getId(), post);
    }

    public Post replace(Post post) {
        return posts.replace(post.getId(), post);
    }

    public List<Post> getAll() {
        return new ArrayList(posts.values());
    }

    public Post getId(int id) {
        return posts.get(id);
    }

    public AtomicInteger getCount() {
        return count;
    }

    public HashMap<Integer, Post> getPosts() {
        return new HashMap<>(posts);
    }

}