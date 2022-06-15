package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.Calendar;
import java.util.HashMap;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {

    private final PostRepository posts;
    private final AtomicInteger count;

    public PostService(PostRepository posts) {
        this.posts = posts;
        this.count = new AtomicInteger((int) posts.count() + 1);
    }

    public void add(Post post) {
        if (getPosts().containsKey(post.getId())) {
            replace(post);
        } else {
            post.setId(count.get());
            count.addAndGet(1);
            post.setCreated(Calendar.getInstance());
            posts.save(post);
        }
    }

    public void replace(Post post) {
        post.setCreated(Calendar.getInstance());
        posts.save(post);
    }

    public Post getId(int id) {
        return posts.findById(id).orElse(null);
    }

    public AtomicInteger getCount() {
        return count;
    }

    public HashMap<Integer, Post> getPosts() {
        HashMap<Integer, Post> rsl = new HashMap<>();
        posts.findAll().forEach(a -> rsl.put(a.getId(), a));
        System.out.println(rsl);
        return rsl;
    }

}