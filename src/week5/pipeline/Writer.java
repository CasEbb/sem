package week5.pipeline;

import week5.adt.Document;

public class Writer extends AbstractFilter {

	@Override
	protected void processData(Document data) {
		System.out.print(data);
	}

}
