package week5.pipeline;

import week5.adt.Document;

public interface Filter {
	public void putData(Document data);
	public void addSink(Filter filter);
}
