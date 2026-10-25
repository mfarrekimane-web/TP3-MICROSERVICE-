package com.example.services;

import com.example.dao.IDao;
import com.example.entities.Salle;
import com.example.dao.SalleDao;   // ajoute cette ligne
import java.util.List;

public class SalleService implements IDao<Salle> {
    private final IDao<Salle> dao = new SalleDao();
    @Override
    public boolean create(Salle o) {
        return dao.create(o);
    }

    @Override
    public boolean delete(Salle o) {
        return dao.delete(o);
    }

    @Override
    public boolean update(Salle o) {
        return dao.update(o);
    }

    @Override
    public Salle getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Salle> getAll() {
        return dao.getAll();
    }
}