package vocabulary.controller;

import java.util.Iterator;

import vocabulary.model.ListVocabulary;
import vocabulary.model.Vocabulary;

public class ChangeVocabulary extends Thread {
	private IChangeVocabulary view;
	private ListVocabulary data;
	private final long SLEEP = 4000;

	public ChangeVocabulary(IChangeVocabulary view, ListVocabulary data) {
		super();
		this.view = view;
		this.data = data;
	}

	@Override
	public void run() {
		Iterator<Vocabulary> iterator = data.iterator();
		while (iterator.hasNext()) {
			Vocabulary vocabulary = iterator.next();
			view.change(vocabulary);
			try {
				Thread.sleep(SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
