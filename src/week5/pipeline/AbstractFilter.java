package week5.pipeline;

import java.util.ArrayList;
import java.util.List;

import week5.adt.Document;

public abstract class AbstractFilter implements Filter {
	
	private List<Filter> sinks;
	
	public AbstractFilter() {
		sinks = new ArrayList<Filter>();
	}
	
	abstract protected void processData(Document data);

	@Override
	public void putData(Document data) {
		processData(data);
		for(Filter sink : sinks) {
			sink.putData(data);
		}
	}

	@Override
	public void addSink(Filter filter) {
		sinks.add(filter);
	}

}
