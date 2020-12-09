package tarot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class Card {
	protected int number;
	protected String type;
	protected String name;
	protected String description;
	protected ArrayList deck;
	protected String image;
	
	public Card() {}
	
	public Card(String name, int number, String type) {
		this.name = name;
		this.number = number;
		this.type= type;
	}
	
	public void addDescription(String description) {
		this.description = description;
	}
	
	public void updateCard(String name, int number) {}

	public void updateCard(String name, int number, String color) {}
	
	public String toString() {
		return this.name;
	}
	
}
