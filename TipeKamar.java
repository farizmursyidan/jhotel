
/**
 * Enumeration class TipeKamar - write a description of the enum class here
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */
public enum TipeKamar
{
    SINGLE("Single"),
    DOUBLE("Double"),
    PREMIUM("Premium");

    public String toString;

    TipeKamar(String toString)
    {
    	this.toString = toString;
    }

    public String toString()
    {
    	return toString;
    }
}