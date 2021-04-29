package service;

import dao.LabDao;
import models.Lab;

import java.util.List;

public class LabService {
    private LabDao dao;

    public LabService() {
        dao = new LabDao();
    }

    public List<Lab> getList() {
        return dao.getList();
    }

    public Lab getById(int id) {
        return dao.getById(id);
    }

    public void create(Object o) {
        dao.insert((Lab) o);
    }

    public void update(Object o) {
        dao.update((Lab) o);
    }

    public void delete(Object o) {
        dao.delete((Lab) o);
    }
}
