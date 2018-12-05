package ch.bbw.zork;

public class Item {
	
	private String name;
	private String description;
	private int weightInGrams;

	public Item(String name, String description, int weightInGrams)
	{
		this.name = name;
		this.description = description;
		this.weightInGrams = weightInGrams;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWeightInGrams() {
		return weightInGrams;
	}

	public void setWeightInGrams(int weight) {
		this.weightInGrams = weight;
	}
}
