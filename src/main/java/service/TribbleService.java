package service;

import dao.TribbleDao;
import models.Tribble;

import java.util.List;

public class TribbleService {
    private TribbleDao dao;

    public TribbleService() {
        dao = new TribbleDao();
    }

    public List<Tribble> getList() {
        return dao.getList();
    }

    public Tribble getById(int id) {
        return dao.getById(id);
    }

    public void create(Object o) {
        dao.insert((Tribble) o);
    }

    public void update(Object o) {
        dao.update((Tribble) o);
    }

    public void delete(Object o) {
        dao.delete((Tribble) o);
    }
}
