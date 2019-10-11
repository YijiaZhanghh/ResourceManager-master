package model.Marketing;

import model.OfficialAccountObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OfficialAccount implements OfficialAccountObserver {
    private static OfficialAccount instance = new OfficialAccount();

    private List<Post> newPosts;
    private List<Post> oldPosts;

    public static OfficialAccount getInstance() {
        return instance;
    }

    private OfficialAccount(){
        oldPosts = new ArrayList<>();
        newPosts = new ArrayList<>();
    }

    @Override
    public void update(Post post) {
        newPosts.add(post);
        //System.out.println(post.getTitle() + ": " + post.getContent());
    }

    public List<Post> getNewPosts() {
        return Collections.unmodifiableList(newPosts);
    }

    public List<Post> getOldPosts() {
        return Collections.unmodifiableList(oldPosts);
    }

    public void viewPosts(){
        oldPosts.addAll(newPosts);
        newPosts = new ArrayList<>();
    }
}
