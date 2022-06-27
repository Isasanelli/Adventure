package com.gioco.thehuntress.battle;

/**
 *
 * @author Margari Chiara
 * @author Ricciardi Raffaella
 * @author Sasanelli Ilenia
 */

/**
 * list of accepted moves.
 */
public enum Move {
    SCHIVA, ATTACCA,PARA;

    /**
     * function that compare the current move with the previous move to determine if it is a tie, if
     * wins or loses.
     *
     * @param  otherMove to perform the comparison
     * @return  1 se questa mossa batte l'altra, -1 se questa mossa viene battuta dall'altra
     *   0 se si tratta di un pareggio
     */

    public int compareMoves(Move otherMove){
        if(this == otherMove){
            return 0;
        }

        switch (this) {
            case SCHIVA:
                if (otherMove == ATTACCA) {
                    return 1;
                } else if (otherMove == PARA) {
                    return -1;
                } else {
                    return 0;
                }
            case PARA:
                if (otherMove == SCHIVA) {
                    return 1;
                } else if (otherMove == ATTACCA) {
                    return -1;
                } else {
                    return 0;
                }
            case ATTACCA:
                if (otherMove == PARA) {
                    return 1;
                } else if (otherMove == SCHIVA) {
                    return -1;
                } else {
                    return 0;
                }
        }
        return 0;
    }
}
