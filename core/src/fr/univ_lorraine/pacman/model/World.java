package fr.univ_lorraine.pacman.model;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by debicki3u on 22/01/16.
 */
public class World {

    private Pacman pc;
    private Ghost ghostbastards[];
    private GameElement[][] geTab;

    private int height;
    private int width;

    public World() {
        pc = new Pacman(new Vector2(13, 7), this);

        ghostbastards = new Ghost[4];

        ghostbastards[0] = new Ghost(new Vector2(13, 17), this, 1);
        ghostbastards[1] = new Ghost(new Vector2(13, 15), this, 2);
        ghostbastards[2] = new Ghost(new Vector2(15, 15), this, 3);
        ghostbastards[3] = new Ghost(new Vector2(11, 15), this, 4);

        int[][] tablo = new int[][]
                {
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,0,0,1,1,2,0,0,0,1,1,1,1,1,3,1,1,1,1,1,0,0,0,0,0,2,0,0,1},
                        {1,0,1,1,0,1,1,0,1,1,0,1,1,1,1,1,3,1,1,1,1,1,0,1,1,0,1,1,1,0,1},
                        {1,0,1,1,0,0,0,0,1,1,0,1,1,1,1,1,3,1,1,1,1,1,0,1,1,0,1,1,1,0,1},
                        {1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,3,1,1,1,1,1,0,1,1,0,1,1,1,0,1},
                        {1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,3,1,1,1,1,1,0,1,1,0,1,1,1,0,1},
                        {1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,3,1,1,1,1,1,1,1,1,0,1,1,1,0,1},
                        {1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,3,1,1,1,1,1,1,1,1,0,1,1,1,0,1},
                        {1,0,1,1,0,0,0,0,1,1,0,1,1,3,3,3,3,3,3,3,1,1,0,0,0,0,1,1,1,0,1},
                        {1,0,1,1,0,1,1,0,1,1,0,1,1,3,1,1,1,1,1,3,1,1,0,1,1,0,1,1,1,0,1},
                        {1,0,1,1,0,1,1,0,1,1,0,1,1,3,1,3,3,3,1,3,1,1,0,1,1,0,1,1,1,0,1},
                        {1,0,0,0,0,1,1,0,0,0,0,1,1,3,1,3,3,3,1,3,0,0,0,1,1,0,0,0,0,0,1},
                        {1,0,1,1,1,1,1,3,1,1,1,1,1,3,1,3,3,3,3,3,1,1,1,1,1,0,1,1,1,1,1},
                        {1,0,0,0,0,1,1,0,0,0,0,1,1,3,1,3,3,3,1,3,0,0,0,1,1,0,0,0,0,0,1},
                        {1,0,1,1,0,1,1,0,1,1,0,1,1,3,1,3,3,3,1,3,1,1,0,1,1,0,1,1,1,0,1},
                        {1,0,1,1,0,1,1,0,1,1,0,1,1,3,1,1,1,1,1,3,1,1,0,1,1,0,1,1,1,0,1},
                        {1,0,1,1,0,0,0,0,1,1,0,1,1,3,3,3,3,3,3,3,1,1,0,0,0,0,1,1,1,0,1},
                        {1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,3,1,1,1,1,1,1,1,1,0,1,1,1,0,1},
                        {1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,3,1,1,1,1,1,1,1,1,0,1,1,1,0,1},
                        {1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,3,1,1,1,1,1,0,1,1,0,1,1,1,0,1},
                        {1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,3,1,1,1,1,1,0,1,1,0,1,1,1,0,1},
                        {1,0,1,1,0,0,0,0,1,1,0,1,1,1,1,1,3,1,1,1,1,1,0,1,1,0,1,1,1,0,1},
                        {1,0,1,1,0,1,1,0,1,1,0,1,1,1,1,1,3,1,1,1,1,1,0,1,1,0,1,1,1,0,1},
                        {1,0,0,0,0,1,1,2,0,0,0,1,1,1,1,1,3,1,1,1,1,1,0,0,0,0,0,2,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                };

        height = tablo[0].length;
        width = tablo.length;

        geTab = new GameElement[width][height];

        for (int col = 0; col < tablo.length; col++) {
            for (int lig = 0; lig < tablo[0].length; lig++) {
                switch (tablo[col][lig]) {
                    case 1:
                        geTab[col][lig] = new Block(new Vector2(col, lig), this);
                        break;
                    case 2:
                        geTab[col][lig] = new SuperPellet(new Vector2(col, lig), this);
                        break;
                    case 0:
                        geTab[col][lig] = new Pellet(new Vector2(col, lig), this);
                        break;
                    default:
                        geTab[col][lig] = null;
                        break;
                }
            }
        }
    }

    public GameElement getGE(int lig, int col){
        return geTab[col][lig];
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public Pacman getPak38(){
        return pc;
    }

    public Ghost getGhost(int whichOne){
        return ghostbastards[whichOne];
    }

    public void destroy(GameElement ge){
        geTab[(int)ge.getPosition().x][(int)ge.getPosition().y] = null;
    }
}
