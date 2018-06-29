package be.gfi.academy.business;

import be.gfi.academy.model.CheckInVO;

/**
 * Service definition for CheckIn.
 */
public interface CheckInService {

    void accept(long checkInId, long userId);

    void reject(long checkInId, long userId);

    CheckInVO next(long userId);
}
