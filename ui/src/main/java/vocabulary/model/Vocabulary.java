package vocabulary.model;

public class Vocabulary {
	private String word;
	private String mean;

	public Vocabulary(String word, String mean) {
		super();
		this.word = word;
		this.mean = mean;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Word: " + this.word + "Mean: " + this.mean;
	}

}
