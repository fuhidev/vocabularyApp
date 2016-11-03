package vocabulary.ui.main;

import java.awt.EventQueue;

import vocabulary.controller.ChangeVocabulary;
import vocabulary.controller.Procuder;
import vocabulary.model.ListVocabulary;
import vocabulary.ui.frVocabulary;
import vocabulary.ui.ss;

public class Main {
	public static void main(String[] args) {
		ListVocabulary listVocabulary = new ListVocabulary();
		Procuder procuder = new Procuder(listVocabulary);
		procuder.run();
		frVocabulary frVocabulary = new frVocabulary();
		ss s = new ss();

		ChangeVocabulary changeVocabulary = new ChangeVocabulary(s, listVocabulary);
		changeVocabulary.start();

		s.setVisible(true);

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					// frVocabulary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
