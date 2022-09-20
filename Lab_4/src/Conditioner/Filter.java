package Conditioner;
/**
 * Class Filter
 * @version 1.0
 */
public class Filter {
    int pollutionStatus = 0;
    int MAX_POLLUTION = 1000;
    /**
     * Method is called every second
     */
    public int tick() throws Exception
    {

        if(pollutionStatus > MAX_POLLUTION)
        {
            throw new Exception("Filter needs to be cleaned!");
        }

        pollutionStatus += 1;

        return pollutionStatus;
    }
    /**
     * Method for cleaning filter
     */
    public void clean()
    {
        pollutionStatus = 0;
    }
}
