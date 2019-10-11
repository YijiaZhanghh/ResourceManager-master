package model.Events;

import model.Marketing.Post;
import model.OfficialAccountObserver;

import java.util.ArrayList;
import java.util.List;

public class OfficialAccountSubject {
    private List<OfficialAccountObserver> oao;

    public OfficialAccountSubject(){
        oao = new ArrayList<>();
    }

    public void addObserver(OfficialAccountObserver obs){
        if(!oao.contains(obs)){
            oao.add(obs);
        }
    }

    public void notifyObservers(Post post){
        for(OfficialAccountObserver o : oao){
            o.update(post);
        }
    }
}
