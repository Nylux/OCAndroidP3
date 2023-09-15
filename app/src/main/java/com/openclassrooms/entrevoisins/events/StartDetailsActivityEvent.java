package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user clicks on a neighbour to see its details
 */
public class StartDetailsActivityEvent {

    /**
     * Neighbour clicked
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public StartDetailsActivityEvent(Neighbour neighbour) {

        this.neighbour = neighbour;
    }
}
