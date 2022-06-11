package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;


@Controller
public class PostControl {

    private final PostService posts;


    public PostControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping({ "/post"})
    public String index(Model model, @RequestParam(name = "id") Integer id) {
        model.addAttribute("post", posts.getId(id));
        return "post";
    }

    @GetMapping({ "/edit"})
    public String edit(Model model, @RequestParam(name = "id") Integer id) {
        model.addAttribute("post", posts.getId(id));
        model.addAttribute("id", id);
        return "edit";
    }

    @GetMapping({ "/new"})
    public String newPost(Model model) {
        model.addAttribute("id", posts.getCount());
        return "edit";
    }

    @PostMapping({ "/new"})
    public String newPost(@ModelAttribute Post post) {
        posts.add(post);
        return "redirect:/";
    }

}
