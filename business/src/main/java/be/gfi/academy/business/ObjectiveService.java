package be.gfi.academy.business;

import be.gfi.academy.model.ObjectiveVO;

import java.util.List;

/**
 * Service definition for {@link ObjectiveVO}.
 */
public interface ObjectiveService {

    ObjectiveVO byId(long id, long userId);

    List<ObjectiveVO> listObjectives(String status, long category, long userId);

}
