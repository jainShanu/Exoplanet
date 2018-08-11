package sort;

import java.util.*;
import utils.Exoplanet;

public class SortbyMass implements Comparator <Exoplanet>{
	public int compare(Exoplanet a , Exoplanet b)
	{
		return a.getMass()-b.getMass();
	}
}
