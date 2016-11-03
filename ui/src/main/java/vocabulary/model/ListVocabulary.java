package vocabulary.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListVocabulary {
	private List<Vocabulary> list;

	public ListVocabulary(List<Vocabulary> list) {
		super();
		this.list = list;
	}

	public ListVocabulary() {
		list = new LinkedList<>();
	}

	public void add(Vocabulary v) {
		this.list.add(v);
	}

	public void remove(Vocabulary v) {
		this.list.remove(v);
	}

	public void remove(int i) {
		this.list.remove(i);
	}

	public Iterator<Vocabulary> iterator() {
		return new IteratorVocabulary(list);
	}
	class IteratorVocabulary implements Iterator<Vocabulary>{
		private List<Vocabulary> list;
		private int index = -1;
		
		public IteratorVocabulary(List<Vocabulary> list) {
			super();
			this.list = list;
		}

		@Override
		public boolean hasNext() {
			if(index < list.size())
				return  true;
			return false;
		}

		@Override
		public Vocabulary next() {
			index++;
			if(index == list.size())
				index =0;
			return list.get(index);
		}
		
	}

}
