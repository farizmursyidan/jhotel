
/**
 * Enumeration class StatusKamar - write a description of the enum class here
 *
 * @author A. Fariz Mursyidan
 * @version 08.03.2018
 */
public enum StatusKamar
{
    BOOKED("Booked"),
    PROCESSED("Processed"),
    VACANT("Vacant");

    public String toString;

    StatusKamar(String toString)
    {
    	this.toString = toString;
    }

    public String toString()
    {
    	return toString;
    }
}
