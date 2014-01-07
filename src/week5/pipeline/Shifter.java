package week5.pipeline;

import week5.adt.Document;

public class Shifter extends AbstractFilter {

	@Override
	protected void processData(Document data) {
		data.shift();
	}

}
