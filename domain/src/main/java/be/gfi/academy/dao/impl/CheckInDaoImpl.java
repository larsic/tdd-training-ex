package be.gfi.academy.dao.impl;

import be.gfi.academy.model.CheckInVO;
import be.gfi.academy.model.UserVO;
import be.gfi.academy.dao.CheckInDao;

import java.util.List;

public class CheckInDaoImpl implements CheckInDao {
    @Override
    public void create(CheckInVO checkIn) {
    }

    @Override
    public void update(CheckInVO checkIn) {

    }

    @Override
    public void delete(CheckInVO checkIn) {

    }

    @Override
    public List<CheckInVO> findAll() {
        return null;
    }


    @Override
    public List<CheckInVO> findAllByAttendee(UserVO attendee) {
        return null;
    }

    @Override
    public List<CheckInVO> findAllByOrganiser(UserVO organiser) {
        return null;
    }

    @Override
    public CheckInVO find(Integer id) {
        return null;
    }

    @Override
    public CheckInVO getNext(UserVO attendee) {
        return null;
    }
}
