package be.gfi.academy.business;

import be.gfi.academy.model.ActionPointVO;

import java.util.List;

/**
 * Service definition for {@link ActionPointVO}.
 */
public interface ActionService {

    List<ActionPointVO> actionsFor(long userId);
}
