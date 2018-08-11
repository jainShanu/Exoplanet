package sort;
import java.util.*;
import utils.Exoplanet;
public class SortbyRadius implements Comparator<Exoplanet>
{
	public int compare(Exoplanet a , Exoplanet b)
	{
		return a.getRadius()-b.getRadius();
	}
}
