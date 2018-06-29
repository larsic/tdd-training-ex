package be.gfi.academy.dao.impl;

import be.gfi.academy.model.TeamVO;
import be.gfi.academy.model.UserVO;
import be.gfi.academy.dao.TeamDao;

import java.util.List;

public class TeamDaoImpl implements TeamDao {
    @Override
    public void create(TeamVO team) {

    }

    @Override
    public void update(TeamVO team) {

    }

    @Override
    public void delete(TeamVO team) {

    }

    @Override
    public TeamVO find(Integer id){
        return null;
    }

    @Override
    public List<TeamVO> findAll() {
        return null;
    }

    @Override
    public List<TeamVO> findAllWithMember(UserVO member) {
        return null;
    }

    @Override
    public List<TeamVO> findAllWithManager(UserVO manager) {
        return null;
    }
}
