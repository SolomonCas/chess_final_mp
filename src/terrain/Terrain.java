package terrain;
/** This is the class that represents the terrain 
 * */
public class Terrain {
	private String strName;
	/**This initializes the terrain and its name 
	 * @param The string that contains the name of that terrain
	 * */
	public Terrain(String name)
	{
		strName = name;
	}
	/**This is the getter for the name of the terrain
	 * */
	public String getName() {
		return strName;
	}
	
	@Override
	public String toString()
	{
		return strName.charAt(0) + "";
	}
	
	/**
	 * This function checks if both Objects
	 * have the same names.
	 * 
	 * @return it returns true if both Objects have the same names, otherwise false.
	 */
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj != null)
		{
			Terrain otherObj = (Terrain) obj;
			
			return otherObj.getName().equals(strName);
		}
		
		return false;
	}
	
}
