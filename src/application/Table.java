package application;

public class Table {

	private String characters;
	private String frequency;
	private String huffmanCode;

	public Table(String characters, String frequency, String huffmanCode) {
		super();

		this.characters = characters;
		this.frequency = frequency;
		this.huffmanCode = huffmanCode;

	}

	public String getCharacters() {
		return characters;
	}

	public void setCharacters(String characters) {
		this.characters = characters;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getHuffmanCode() {
		return huffmanCode;
	}

	public void setHuffmanCode(String huffmanCode) {
		this.huffmanCode = huffmanCode;
	}
}
