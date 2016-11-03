package vocabulary.controller;

import vocabulary.model.ListVocabulary;
import vocabulary.model.Vocabulary;

public class Procuder {
	private ListVocabulary list;

	public Procuder(ListVocabulary list) {
		super();
		this.list = list;
	}

	public Procuder() {
		list = new ListVocabulary();
		
	}
	public void run(){
		for (int i = 0; i < 4; i++) {
			list.add(new Vocabulary("Hello " + i, "Xin chào" + i));
		}
	}
}
