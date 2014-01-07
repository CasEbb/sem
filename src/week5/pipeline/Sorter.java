package week5.pipeline;

import week5.adt.Document;

public class Sorter extends AbstractFilter {

	@Override
	protected void processData(Document data) {
		data.sort();
	}

}
