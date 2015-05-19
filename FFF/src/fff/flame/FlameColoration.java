package fff.flame;

/**
 * Class {@code FlameColoration} provides accessors methods to a {@link Flame}'s
 * coloration parameters: {@code brightness}, {@code gamma}, and
 * {@code vibrancy}. These parameters affect the appearance of colors of the
 * flame.
 *
 * @author Jeremiah N. Hankins
 */
public class FlameColoration {
    private final Flame flame;
    
    FlameColoration(Flame flame) {
        this.flame = flame;
    }
    
    /**
     * Sets the brightness, gamma, and vibrancy values.
     * 
     * @param brightness the brightness coefficient
     * @param gamma the gamma correction value
     * @param vibrancy the vibrancy value
     * @throws IllegalArgumentException if {@code brightness} is not in range (0,inf)
     * @throws IllegalArgumentException if {@code gamma} is not in range (0,inf)
     * @throws IllegalArgumentException if {@code vibrancy} is not in range [0,1]
     */
    public void set(float brightness, float gamma, float vibrancy) {
        setBrightness(brightness);
        setGamma(gamma);
        setVibrancy(vibrancy);
    }
    
    /**
     * Sets the linear brightness scale.
     * 
     * @param brightness the brightness
     * @throws IllegalArgumentException if {@code brightness} is not in range (0,inf)
     */
    public void setBrightness(float brightness) {
        if (!(0<brightness && brightness<Float.POSITIVE_INFINITY))
            throw new IllegalArgumentException("brightness is not in range (0,inf): "+brightness);
        flame.flameColoration[0] = brightness;
    }
    
    /**
     * Sets the gamma color correction value.
     * 
     * @param gamma the gamma
     * @throws IllegalArgumentException if {@code gamma} is not in range (0,inf)
     */
    public void setGamma(float gamma) {
        if (!(0<gamma && gamma<Float.POSITIVE_INFINITY))
            throw new IllegalArgumentException("gamma is not in range (0,inf): "+gamma);
        flame.flameColoration[1] = 1.0f/gamma;
    }
    
    /**
     * Sets the vibrancy. The vibrancy is a value between 0 and 1 that
     * determines to what extent gamma correction will be applied based on the
     * alpha channel or applied to each color channel individually.
     * 
     * @param vibrancy the vibrancy
     * @throws IllegalArgumentException if {@code vibrancy} is not in range [0,1]
     */
    public void setVibrancy(float vibrancy) {
        if (!(0<=vibrancy && vibrancy<=1))
            throw new IllegalArgumentException("vibrancy is not in range [0,1]: "+vibrancy);
        flame.flameColoration[2] = vibrancy;
    }
    
    /**
     * Returns the linear brightness scale.
     * 
     * @return the brightness
     */
    public float getBrightness() {
        return flame.flameColoration[0];
    }
    
    /**
     * Returns the gamma color correction value.
     * 
     * @return gamma the gamma
     * @see <a href="https://en.wikipedia.org/wiki/Gamma_correction">https://en.wikipedia.org/wiki/Gamma_correction</a>
     */
    public float getGamma() {
        return 1.0f/flame.flameColoration[1];
    }
    
    /**
     * Returns the vibrancy. The vibrancy is a value between 0 and 1 that
     * determines to what extent gamma correction will be applied based on the 
     * alpha channel or applied to each color channel individually.
     * 
     * @return the vibrancy
     */
    public float getVibrancy() {
        return flame.flameColoration[2];
    }

    @Override
    public String toString() {
        return "Coloration("+getBrightness()+", "+getGamma()+", "+getVibrancy()+")";
    }
}