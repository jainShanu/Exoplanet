package sort;

import java.util.*;
import utils.Exoplanet;

public class SortbyOrbitalPeriod implements Comparator <Exoplanet>{
	public int compare(Exoplanet a , Exoplanet b)
	{
		return a.getOrbital_period()-b.getOrbital_period();
	}
}
