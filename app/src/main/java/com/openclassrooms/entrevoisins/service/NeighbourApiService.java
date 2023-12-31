package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);

    /**
     * Get all favorite neighbours
     * @return {@link List}
     */
    List<Neighbour> getFavoriteNeighbours();

    /**
     * Adds a neighbour to the favorites
     * @param neighbour The neighbour to add to the favorites list
     */
    void addFavoriteNeighbour(Neighbour neighbour);

    /**
     * Removes a neighbour from the favorites
     * @param neighbour The neighbour to remove from the favorites list
     */
    void deleteFavoriteNeighbour(Neighbour neighbour);
}
