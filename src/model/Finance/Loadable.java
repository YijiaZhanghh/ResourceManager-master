package model.Finance;

import model.exceptions.LoadFailException;

import java.io.IOException;

public interface Loadable {
    public String load() throws IOException, LoadFailException;
}
