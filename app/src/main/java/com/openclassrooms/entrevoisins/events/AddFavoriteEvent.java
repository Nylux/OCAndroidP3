package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user adds a Neighbour to their favorite
 */
public class AddFavoriteEvent {

    /**
     * Neighbour to add to favorites
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public AddFavoriteEvent(Neighbour neighbour) {

        this.neighbour = neighbour;
    }
}
