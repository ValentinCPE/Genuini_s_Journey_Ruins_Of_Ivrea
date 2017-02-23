/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genuini.world;

/**
 *
 * @author Adrien
 */
public class PhysicsVariables {
    // pixels per meter
    public static final float PPM = 100;
	
    // collision bit filters
    public static final short BIT_PLAYER = 2;
    public static final short BIT_TERRAIN = 4;
    public static final short BIT_FIREBALL = 8;
    public static final short BIT_TURRET = 16;
}
