package be.gfi.academy.dao;

import be.gfi.academy.model.CheckInVO;
import be.gfi.academy.model.UserVO;

import java.util.List;

public interface CheckInDao {
    public static final String LOCATION_COLUMN = "location";
    public static final String MEETINGDATE_COLUMN = "meetingdate";

    /**
     * @param checkIn The CheckIn to create
     * */
    void create(CheckInVO checkIn);

    /**
     * @param checkIn The CheckIn to update
     * */
    void update(CheckInVO checkIn);

    /**
     * @param checkIn The CheckIn to delete
     * */
    void delete(CheckInVO checkIn);

    /**
     * @return List of all Checkins
     * */
    List<CheckInVO> findAll();

    /**
     * @param attendee the User attending these CheckIns
     * @return List of all CheckIns attended by this User
     * */
    List<CheckInVO> findAllByAttendee(UserVO attendee);

    /**
     * @param organiser the User organising these CheckIns
     * @return List of all CheckIns organised by this User
     * */
    List<CheckInVO> findAllByOrganiser(UserVO organiser);

    /**
     * @param id identifier of CheckIn entity
     * @return the CheckIn entity with the given id
     *         null if id cannot be found
     * */
    CheckInVO find(Integer id);

    /**
     * @param attendee the attendee of this CheckIn
     * @return the earliest CheckIn scheduled for this attendee
     * null if no more CheckIns scheduled in the future
     * */
    CheckInVO getNext(UserVO attendee);
}
