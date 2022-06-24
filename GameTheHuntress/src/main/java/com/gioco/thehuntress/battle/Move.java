package com.gioco.thehuntress.battle;

public enum Move {
    SCHIVA, ATTACCA,PARA;

    /**
     * Confrontiamo la mossa corrente con la mossa precedente per determinare se è un pareggio, se
     * vince o se perde
     *
     * @parametro otherMove per eseguire il confronto
     * @return 1 se questa mossa batte l'altra, -1 se questa mossa viene battuta dall'altra
     *   0 se si tratta di un pareggio
     */

    public int compareMoves(Move otherMove){
        //caso di parità
        if(this == otherMove){
            return 0;
        }

        switch (this){
            case SCHIVA:
                if (otherMove==PARA){
                    return -1;
                }else if (otherMove== ATTACCA){
                    return 1;
                }else{
                    return 0;
                }
            case PARA:
                if (otherMove==SCHIVA){
                    return 1;
                }else if (otherMove== ATTACCA){
                    return-1;
                }else{
                    return 0;
                }
            case ATTACCA:
                if (otherMove==SCHIVA){
                    return 1;
                }else if (otherMove==PARA){
                    return-1;
                }else{
                    return 0;
                }
        }// Il programma non dovrebbe mai raggiungere questo punto
        return 0;
    }
}
