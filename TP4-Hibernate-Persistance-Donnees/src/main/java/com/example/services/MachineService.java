package com.example.services;

import com.example.dao.IDao;
import com.example.dao.MachineDao;
import com.example.entities.Machine;
import java.util.List;

public class MachineService implements IDao<Machine> {
    private final MachineDao dao = new MachineDao();   // type MachineDao, pas IDao

    @Override
    public boolean create(Machine o) { return dao.create(o); }

    @Override
    public boolean delete(Machine o) { return dao.delete(o); }

    @Override
    public boolean update(Machine o) { return dao.update(o); }

    @Override
    public Machine getById(int id) { return dao.getById(id); }

    @Override
    public List<Machine> getAll() { return dao.getAll(); }

    public List<Machine> findByMarque(String marque) {
        return dao.findByMarque(marque);
    }
}